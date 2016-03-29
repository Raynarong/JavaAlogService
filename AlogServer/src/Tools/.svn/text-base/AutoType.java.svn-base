package Tools;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class AutoType {
	 
	 
public static String getReturnType(String s) throws  Exception{
	  Map<String,String> map=new HashMap<String,String>();
	  JSONObject obj=new JSONObject();
	String ClassPath =new FilePath().RecievDate;
	URLClassLoader loader=new URLClassLoader(new URL[]{new URL("file:"+ClassPath+"\\")});
	Class ownerClass=loader.loadClass(s);
	Method[] methods=ownerClass.getDeclaredMethods();
	for(Method method: methods){
   		if(method.getName()=="apply"){
   			Type reType= method.getGenericReturnType();
   			Type colType=method.getReturnType();
   			Class geType=method.getReturnType();
   			if(colType==reType){
   			obj.put("returnType",geType.getSimpleName());	
   			}
   			else{
   				String a=reType.toString().replaceAll("java.lang.|java.util.","");
   				obj.put("returnType",a);	
   			}
   			Class[]types=method.getParameterTypes();
   		    Type[] pType = method.getParameterTypes();   
   		    Type[] neiType = method.getGenericParameterTypes();
   		//    String[] para=new String[pType.length];
   		    List para=new ArrayList();
         for(int i=0;i<pType.length;i++){
        	 if(pType[i]==neiType[i]){
   			   para.add(types[i].getSimpleName());
        	 }
        	 else{
        		 int version=javaVersion.javaVersion0();
        		 String index="";
        		 if(version==6){
        			index= neiType[i].toString();	 
        		 }
        		 else if(version==7){
        			 index=class4base.changBase(neiType[i].toString());
        		 }
        		 String temp=index.replaceAll("java.lang.|java.util.","");
        		 para.add(temp);
        	 }
   		 }
         obj.put("returnParameter", para.toString());
       
   		}}
	//JSONObject jsonObject = JSONObject.fromObject(map);
	String jso=obj.toString();
	 return jso;
}

public static List<String> getParameterType(String s) throws  Exception{
	  Map<String,String> map=new HashMap<String,String>();
	  JSONObject obj=new JSONObject();
	String ClassPath =new FilePath().RecievFile;
	URLClassLoader loader=new URLClassLoader(new URL[]{new URL("file:"+ClassPath+"\\")});
	Class ownerClass=loader.loadClass(s);
	Method[] methods=ownerClass.getDeclaredMethods();
	List<String> para=new ArrayList<String>();
	for(Method method: methods){
		if(method.getName()=="apply"){
			Type reType= method.getGenericReturnType();
			Type colType=method.getReturnType();
			Class geType=method.getReturnType();
			if(colType==reType){
			obj.put("returnType",geType.getSimpleName());	
			}
			else{
				String a=reType.toString().replaceAll("java.lang.|java.util.","");
				obj.put("returnType",a);	
			}
			Class[]types=method.getParameterTypes();
		    Type[] pType = method.getParameterTypes();   
		    Type[] neiType = method.getGenericParameterTypes();
		//    String[] para=new String[pType.length];
		    for(int index=0;index<neiType.length;index++){
		    	System.out.println(index + neiType[index].toString());
		    	
		    }
		    
     for(int i=0;i<pType.length;i++){
    	 if(pType[i]==neiType[i]){
			   para.add(types[i].getSimpleName());
    	 }
    	 else{
    		 int version=javaVersion.javaVersion0();
    		 String index="";
    		 if(version==6){
    			index= neiType[i].toString();	 
    		 }
    		 else if(version==7){
    			 index=class4base.changBase(neiType[i].toString());
    		 }
    		 String temp=index.replaceAll("java.lang.|java.util.","");
    		 para.add(temp);
    	 }
		 }
    
   
		}}
	//JSONObject jsonObject = JSONObject.fromObject(map);
	String jso=obj.toString();
	 for(int index=0;index<para.size();index++){
	    	System.out.println("nihao"+ para.get(index).toString());
	    	
	    }
	 return para;
}
}
