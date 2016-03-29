package RpcService;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;

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

import Tools.AutoType;
import Tools.FilePath;

public class HelloWorldServiceCopy {
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

	public HelloWorldServiceCopy(){
		System.out.println("HelloWorldService-----------");
	}

	String ClassPath =new FilePath().RecievDate;
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

         		Class[]types=method.getParameterTypes();  

       		Object[] args=getDTOArray(s,json);
       		  a=method.invoke(owner, args);   
       		 System.out.println("返回值为："+a);
       		}
       	}    
       	 
       	
       }catch (Exception e) {
           e.printStackTrace();
       }
		return  a;       
    
} 
	

	public static Object[] getDTOArray(String location, String jsonString) throws Exception{
		List re=AutoType.getParameterType(location);
		JSONArray array = JSONArray.fromObject(jsonString);
    	Object[] obj=new Object[array.size()];
    	for(int i=0;i<array.size();i++){
    		String paType=re.get(i).toString();
    		System.out.println("paType:"+paType);
    	    if(paType.equals("Map<String, Double[]>")) {
    	    	  Map map=new HashMap();
            	  JSONObject inArrer= JSONObject.fromObject(array.get(i).toString());
            	  Iterator keys=inArrer.keys();
            	  while(keys.hasNext()){
            		  String s=keys.next().toString();
             		 System.out.println(s);
             		 String value=inArrer.get(s).toString();
             		 Object typeValue;
             		JSONArray inArr=JSONArray.fromObject(value);
             		 Double[] ar=new Double[inArr.size()]; //暂时写为DOuble；
   				  for(int ii=0;ii<inArr.size();ii++){
   					  ar[ii]=inArr.getDouble(ii);
   				  }
   				  typeValue=ar;
   				 map.put(s, typeValue);
            	  }
            	  obj[i]=map;
    	    }
    	    else  if(paType.equals("Map<String, String[]>")){
    	    	  Map map=new HashMap();
            	  JSONObject inArrer= JSONObject.fromObject(array.get(i).toString());
            	  Iterator keys=inArrer.keys();
            	  while(keys.hasNext()){
            		  String s=keys.next().toString();
             		 System.out.println(s);
             		 String value=inArrer.get(s).toString();
             		 Object typeValue;
             		JSONArray inArr=JSONArray.fromObject(value);
             		 String[] ar=new String[inArr.size()]; //暂时写为DOuble；
   				  for(int ii=0;ii<inArr.size();ii++){
   					  ar[ii]=inArr.getString(ii);
   				  }
   				  typeValue=ar;
   				 map.put(s, typeValue);
            	  }
            	  obj[i]=map;
    	    }
    	    else if(paType.equals("Map<String, int[]>")){
    	    	  Map map=new HashMap();
            	  JSONObject inArrer= JSONObject.fromObject(array.get(i).toString());
            	  Iterator keys=inArrer.keys();
            	  while(keys.hasNext()){
            		  String s=keys.next().toString();
             		 System.out.println(s);
             		 String value=inArrer.get(s).toString();
             		 Object typeValue;
             		JSONArray inArr=JSONArray.fromObject(value);
             		 int[] ar=new int[inArr.size()]; //暂时写为DOuble；
   				  for(int ii=0;ii<inArr.size();ii++){
   					  ar[ii]=inArr.getInt(ii);
   				  }
   				  typeValue=ar;
   				 map.put(s, typeValue);
            	  }
            	  obj[i]=map;
    	    }
    	    else  if(paType.equals("Map<String, String>")){
  	    	  Map map=new HashMap();
          	  JSONObject inArrer= JSONObject.fromObject(array.get(i).toString());
          	  Iterator keys=inArrer.keys();
          	  while(keys.hasNext()){
          		  String s=keys.next().toString();
           		 System.out.println(s);
           		 String value=inArrer.get(s).toString();
 				 map.put(s, value);
          	  }
          	  obj[i]=map;
  	    }
    	    else  if(paType.equals("int[]")){
    	    	 JSONArray inArr=JSONArray.fromObject(array.get(i).toString());
				  int[] ar=new int[inArr.size()];
				  for(int index=0;index<inArr.size();index++){
					  ar[index]=inArr.getInt(index);
				  }
				  obj[i]=ar;
    	    }
    	    else  if(paType.equals("Double[]")){
    	    	 JSONArray inArr=JSONArray.fromObject(array.get(i).toString());
				  Double[] ar=new Double[inArr.size()];
				  for(int index=0;index<inArr.size();index++){
					  ar[index]=inArr.getDouble(index);
				  }
				  obj[i]=ar;
    	    }
    	    else if(paType.equals("String[]")){
    	    	 JSONArray inArr=JSONArray.fromObject(array.get(i).toString());
				  String[] ar=new String[inArr.size()];
				  for(int index=0;index<inArr.size();index++){
					  ar[index]=inArr.getString(index);
				  }
				  obj[i]=ar;
    	    }
    	    else{
    	    	obj[i]=array.get(i);
    	    }
    	    
    	}
    	for(int aa=0;aa<obj.length;aa++){
    		System.out.println(aa+obj[aa].getClass().toString());
    	}
    	return obj;
		
 		 } 
	

	public Object ReturnParaMeter(String s )throws Exception{
		 return AutoType.getReturnType(s);
	}
public static void main(String args[]) throws Exception{
	
	
}
        	
        }


