package Tools;

import java.util.Map;

public class class4base {
  public static String changBase(String s){
	  String re="";
	  if(s.equals("Map<String, Double[]>")) {
	    	
	    }
	    else  if(s.equals("java.util.Map<java.lang.String, [Ljava.lang.Double;>")){
	    	re="java.util.Map<java.lang.String, java.lang.Double[]>";
	    }
	    else if(s.equals("java.util.Map<java.lang.String, [Ljava.lang.Integer;>")){
	    	re="java.util.Map<java.lang.String, java.lang.Integer[]>";
	    }
	    else if(s.equals("java.util.Map<java.lang.String, [Ljava.lang.Long;>")){
	    	
	    	re="java.util.Map<java.lang.String, java.lang.Long[]>";
	    }
	    else  if(s.equals("java.util.Map<java.lang.String, [Ljava.lang.String;>")){
    	 re="java.util.Map<java.lang.String, java.lang.String[]>";
    }
	    else{
	    	re=s;
	    }
	  return re;
  }
public static void main(String args[]){
	System.out.println(java.lang.String[].class);
}	
	
}
