package RpcService;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import Tools.FilePath;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class JarLoaderTest {
	String ClassPath =new FilePath().RecievDate;
	public Object invokeMethod(String s,String json )throws Exception {
		 
		URLClassLoader loader=new URLClassLoader(new URL[]{new URL("file:"+ClassPath+"\\")});
		System.out.println("file:"+ClassPath);
		Class ownerClass=loader.loadClass(s);
        Object owner=ownerClass.newInstance();
        
      //  JSONObject js = new JSONObject();
        Object a=new Object();
    System.out.println(json);
    	try{
       	Method[] methods=ownerClass.getDeclaredMethods();
       	Object result;
       	for(Method method: methods){
       		if(method.getName()=="apply"){

         		Class[]types=method.getParameterTypes();  

       		Object[] args=getDTOArray(json,types);
       		  a=method.invoke(owner, args);   
       		 System.out.println("返回值为："+a);
       		}
       	}    
       	 
       	
       }catch (Exception e) {
           e.printStackTrace();
       }
		return  a;       
    
} 
	

	private static class JarLoader {
			private URLClassLoader urlClassLoader;
			public JarLoader(URLClassLoader urlClassLoader) {
				this.urlClassLoader = urlClassLoader;
			}
			
			public void loadJar(URL url) throws Exception {
				Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
				addURL.setAccessible(true);
				addURL.invoke(urlClassLoader, url);
			}
		}

	private static void loadjar(JarLoader jarLoader, String path) throws MalformedURLException, Exception{
			File libdir = new File(path);
			if (libdir != null && libdir.isDirectory()) {
				
				File[] listFiles = libdir.listFiles(new FileFilter() {
					
				
					public boolean accept(File file) {
						// TODO Auto-generated method stub
						return file.exists() && file.isFile() && file.getName().endsWith(".jar");
					}
				});
				
				for (File file : listFiles) {
					jarLoader.loadJar(file.toURI().toURL());
				}
				
			}else{
				System.out.println("[Console Message] Directory ["+path+"] does not exsit, please check it");
				System.exit(0);
			}
		}
      
	public static Object[] getDTOArray(String jsonString, Class[] clazz){
	 	
		JSONArray array = JSONArray.fromObject(jsonString);
		Object[] obj= new Object[array.size()];
		// 把客户端传过来的值转换成apply函数中对应的参数
		  for(int p=0;p<array.size();p++){
			  Pattern pattern = Pattern.compile("^\\[([0-9]*,)*[0-9]*\\]$");
			  Matcher matcher = pattern.matcher(array.get(p).toString());
			  System.out.println(array.get(p).toString());
			  boolean b= matcher.matches();
			  Pattern strPattern = Pattern.compile("^\\[(\".*\",)*\".*\"\\]$");
  			  Matcher strMatcher = strPattern.matcher(array.get(p).toString());
  			  boolean Strbo= strMatcher.matches();
			  if(b==true){
				  System.out.println("match sucessfully"); 
				  System.out.println(array.get(p).getClass()); 
				  JSONArray inArr=JSONArray.fromObject(array.get(p).toString());
				  int[] ar=new int[inArr.size()];
				  for(int i=0;i<inArr.size();i++){
					  ar[i]=inArr.getInt(i);
				  }
				  obj[p]=ar;
				  System.out.println("obj:"+obj[p].getClass()+"objcontest:"+obj[p].toString());
			  }
			  else if(Strbo==true){
				  System.out.println("Stringmatch sucessfully"); 
				  System.out.println(array.get(p).getClass()); 
				  JSONArray inArr=JSONArray.fromObject(array.get(p).toString());
				  String[] ar=new String[inArr.size()];
				  for(int i=0;i<inArr.size();i++){
					  ar[i]=inArr.getString(i);
				  }
				  obj[p]=ar;
				  System.out.println("obj:"+obj[p].getClass()+"objcontest:"+obj[p].toString());
				  
			  }
			  else obj[p]=array.get(p);
			  
		  }
		  return obj; 
 		 } 
	public static void main(String[] args) throws MalformedURLException, Exception {
	//		JarLoader jarLoader = new JarLoader((URLClassLoader)ClassLoader.getSystemClassLoader());
		    File file_err = new File("c://testsave/"+"Test/"+"err.txt");
    		if(!file_err.exists())
    		{
    			file_err.createNewFile();
    		}
    		OutputStream out1 = new FileOutputStream(file_err);
    		 
    		 
          String classpath="c://testsave/";
          String javaPath="c://testsave/"+"Raynarong/Test.java";
	 //      loadjar(jarLoader, "C://jarPath/Raynarong");
	       JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
   	    	int result = compiler.run(null, null, out1,"-d",classpath, javaPath);
   	    	System.out.println("result :"+ result);
	      /* JarLoaderTest test=new JarLoaderTest();
	       String s="Test";
	       String json="[]";
	       
	       test.invokeMethod(s, json);*/

	}
}
