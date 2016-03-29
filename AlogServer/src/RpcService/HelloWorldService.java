package RpcService;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.net.URLClassLoader;
import java.net.URL;
import java.net.MalformedURLException; 
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import HandleService.ReturnObjectArray;
import Tools.AutoType;
import Tools.FilePath;
import Tools.JSONUtil;

public class HelloWorldService {
	
	/**
	 * 反射时动态加载jar包
	 * @author Administrator
	 *
	 */
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
			//System.exit(0);
		}
	}
   public static String getUserName(String className){
	   return className.substring(0, className.indexOf("."));
	   
   }

	public HelloWorldService(){
		System.out.println("HelloWorldService-----------");
	}

	String ClassPath =new FilePath().RecievDate;
	
	/**
	 * 传入类名和参数的json数组字符串，通过反射调用.class类
	 * @param s
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public Object invokeMethod(String s,String json )throws Exception {
		JarLoader jarLoader = new JarLoader((URLClassLoader)ClassLoader.getSystemClassLoader());
		String filePath = new FilePath().RecievJar;
        String jarPath=filePath+getUserName(s);
        	
	     loadjar(jarLoader, jarPath);
		 
		URLClassLoader loader=new URLClassLoader(new URL[]{new URL("file:"+ClassPath+"\\")});
		System.out.println("file:"+ClassPath);
		Class ownerClass=loader.loadClass(s);
		System.out.println("载入的类名："+s);
        Object owner=ownerClass.newInstance();
        
      //  JSONObject js = new JSONObject();
        Object a=new Object();
    System.out.println(json);
    	try{
       	Method[] methods=ownerClass.getDeclaredMethods();
       	Object result;
       	for(Method method: methods){
       		if(method.getName()=="apply"){
       			Gson gson = new Gson();

         		Type[]types=method.getGenericParameterTypes();  
                Object[] obj=new Object[types.length];
         		//JSONArray array = JSONArray.fromObject(json);
                JsonParser parser = new JsonParser();
        		JsonArray arr = parser.parse(json).getAsJsonArray();
        		if(types.length==arr.size()){
         		for(int i=0;i<types.length;i++){
         			obj[i]=gson.fromJson(arr.get(i), types[i]);
         			System.out.println("type:"+types[i]);
         			System.out.println("json"+obj[i].getClass());
         		}
           
       		// Object[] args=ReturnObjectArray.getDTOArray(s,json);
       	  
   		 
       		  a=method.invoke(owner, obj);   
       		 
       		 System.out.println("返回值为："+a);
        		}
       		}
       	}    
       	 
       	
       }catch(InvocationTargetException ex){
    	 //  InvocationTargetException targetEx = (InvocationTargetException)ex; 
    	 //  Throwable t = targetEx .getTargetException();
    	//   System.out.println( (Exception)targetEx.getMessage());
    	} 
		return  a;       
    
} 
	
 /**
  * 返回apply方法的参数名数组列表和apply的返回值类型
  * @param s
  * @return
  * @throws Exception
  */
	
	public Object ReturnParaMeter(String s )throws Exception{
		 return AutoType.getReturnType(s);
	  }
	/**
	 * personal test
	 * @param args
	 * @throws Exception 
	 * @throws Exception
	 */
public static void main(String args[]) throws Exception {
	
	HelloWorldService hell=new HelloWorldService();
	String a="Raynarong.HeapSort.HeapSort";
	String b="[[3,2,1,5,6]]";
	hell.invokeMethod(a, b);
}
        	
        }

