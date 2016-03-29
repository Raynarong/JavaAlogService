package Load;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Tools.FilePath;

public class ReceiveFileData extends HttpServlet {

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
                    System.out.println("fName:"+fName);
                    System.out.println("fValue:"+fValue);
                    map.put(fName, fValue);  
                } else { // 获取上传文件的值  
                    fName = fItem.getFieldName();  
                    fValue = fItem.getInputStream();
                    System.out.println("fName:"+fName);
                    System.out.println("fValue:"+fValue);
                    map.put(fName, fValue);  
                    String name = fItem.getName();  
                    if(name != null && !("".equals(name))) {  
                        name = name.substring(name.lastIndexOf(File.separator) + 1);  
                       String  recFilePath=new FilePath().SaveDate;
                          
//                      String stamp = StringUtils.getFormattedCurrDateNumberString();  
//                        String timestamp_Str = TimeUtils.getCurrYearYYYY();  
                        directory = new File(recFilePath+fName);    
                             directory.mkdirs();  
                          
                        String filePath = recFilePath +fName+"/"+ name; 
                        System.out.println(filePath);
                        map.put(fName + "FilePath", filePath);  
                          
                        InputStream is = fItem.getInputStream();  
                        FileOutputStream fos = new FileOutputStream(filePath);  
                        byte[] buffer = new byte[1024];  
                        int length=0;
                        while ((length=is.read(buffer)) > 0) {  
                            fos.write(buffer, 0, length);  
                        }  
                        fos.flush();  
                        fos.close();  
                        map.put(fName + "FileName", name);  
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

}
             
                                  
