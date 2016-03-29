package Load;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Tools.FilePath;

public class SaveData extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = null;  
        response.setContentType("text/html;charset=UTF-8");  
          
        Map map = new HashMap();  
        FileItemFactory factory = new DiskFileItemFactory();  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        File directory = null;    
        List<FileItem> items = new ArrayList();  
        try {  
            items = upload.parseRequest(request);  
            // 得到所有的文件  
            Iterator<FileItem> it = items.iterator();  
            while (it.hasNext()) {  
                FileItem fItem = (FileItem) it.next();  
                String fName = "";  
                Object fValue = null;  
                if (fItem.isFormField()) { // 普通文本框的值  
                    fName = fItem.getFieldName();  
//                  fValue = fItem.getString();  
                    fValue = fItem.getString("UTF-8"); 
                    System.out.println("fName1:"+fName);
                    System.out.println("fValue1:"+fValue);
                    map.put(fName, fValue);  
                } else { // 获取上传文件的值  
                    fName = fItem.getFieldName();  
                    fValue = fItem.getInputStream();
                    System.out.println("fName:"+fName);
                    System.out.println("fValue:"+fValue);
                    map.put(fName, fValue);  
                    String name = fItem.getName();  
                    String savePath=new FilePath().RecievDate;
                    String filePathJar = new FilePath().RecievJar;
                    File jarSavePath=new File(filePathJar+fName);
                    if(!jarSavePath .exists()  && !jarSavePath .isDirectory()){
                    	jarSavePath .mkdir(); 
                    }
                    if(name != null && !("".equals(name))) {  
                        name = name.substring(name.lastIndexOf(File.separator) + 1);  
                          
//                      String stamp = StringUtils.getFormattedCurrDateNumberString();  
//                        String timestamp_Str = TimeUtils.getCurrYearYYYY();  
                        directory = new File(savePath+fName);    
                             directory.mkdirs();  
                        String jarFilePath = new FilePath().RecievJar;
                        directory = new File(jarFilePath+fName);   
                              directory.mkdirs();
                        String jarPath = savePath +fName+"/"+ name; 
                        String filePath=savePath +fName;
                        System.out.println("jarPath:"+jarPath);
                        map.put(fName + "FilePath", jarPath);  
                          
                        InputStream is = fItem.getInputStream();  
                        FileOutputStream fos = new FileOutputStream(jarPath);  
                        byte[] buffer = new byte[1024];  
                        int length=0;
                        while ((length=is.read(buffer)) > 0) {  
                            fos.write(buffer, 0, length);  
                        }  
                        fos.flush();  
                        fos.close();  
                        map.put(fName + "FileName", name);  
	
                        SaveData.zipToFile(jarPath, filePath);
                        File JarFile=new File(jarPath);
                        JarFile.delete();
                    }  
                } 
                
            }  
            try {  
        	    out = response.getWriter();
                out.print("success");
                out.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            } 
            
        } catch (Exception e) {  
        	try {  
        	    out = response.getWriter();
                out.print("error");
                out.close();  
            } catch (IOException ex) {  
                e.printStackTrace();  
            } 
        }
  
	}
	
	/**
	 * 将zip文件解压到targetPath目录下
	 * @param zipFilePath zip文件地址，到.zip
	 * @param targetPath 解压缩目录
	 * @throws IOException 
	 */
	public static void zipToFile(String zipFilePath, String targetPath) throws IOException{
		OutputStream os = null;
		InputStream is = null;
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(zipFilePath);
			String directoryPath = "";
			if(null == targetPath || "".equals(targetPath))
			{
				directoryPath = zipFilePath.substring(0, zipFilePath.lastIndexOf("."));
			}
			else
			{
				directoryPath = targetPath;
			}
			Enumeration entryEnum = zipFile.entries();
			if(null != entryEnum)
			{
				ZipEntry zipEntry = null; 
				while(entryEnum.hasMoreElements())
				{
					zipEntry = (ZipEntry) entryEnum.nextElement();
					if(zipEntry.isDirectory())
					{
						directoryPath = directoryPath + File.separator + zipEntry.getName();
						System.out.println(directoryPath);
						continue;
					}
					if(zipEntry.getSize() > 0)
					{
						File targetFile = buildFile(directoryPath + File.separator + zipEntry.getName(), false);
						os = new BufferedOutputStream(new FileOutputStream(targetFile));
						is = zipFile.getInputStream(zipEntry);
						byte[] buffer = new byte[4096];
						int readLen = 0;
						while((readLen = is.read(buffer, 0, 4096)) >= 0)
						{
							os.write(buffer, 0, readLen);
						}
						os.flush();
						os.close();
						
				        
					}
					else
					{
						//空目录
						buildFile(directoryPath + File.separator + zipEntry.getName(), true);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null != zipFile)
			{
				zipFile.close();
			}
			try {
				if(null != is)
				is.close();
				if(null != os)
				{
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		File jarFile=new File(zipFilePath);
        System.out.println("jarPath:"+zipFilePath);
		if(jarFile.exists()){
        	System.out.println("文件存在否："+jarFile.exists());
          jarFile.delete();
          }
		
	}
	
	/**
	 * 生成文件的方法类
	 * @param fileName
	 * @param isDirectory
	 * @return
	 */
	public static File buildFile(String fileName, boolean isDirectory)
	{
		File target = new File(fileName);
		if(isDirectory)
		{
			target.mkdirs();
		}
		else
		{
			if(!target.getParentFile().exists())
			{
				target.getParentFile().mkdirs();
				target = new File(target.getAbsolutePath());
			}
		}
		return target;
	}

}
             
                                  
