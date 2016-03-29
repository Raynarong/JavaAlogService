package HandleService;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import Tools.AutoType;
import Tools.JSONUtil;

public class ReturnObjectArray {
 /**
  * return reflection's Object[]
  * @param location
  * @param jsonString
  * @return
  * @throws Exception
  */
	public static Object[] getDTOArray(String location, String jsonString) throws Exception{
		List re=AutoType.getParameterType(location);
		JSONArray array = JSONArray.fromObject(jsonString);
    	Object[] obj=new Object[array.size()];
    	for(int i=0;i<array.size();i++){
    		String paType=re.get(i).toString();
    		System.out.println("paType:"+paType);
    		String value=array.get(i).toString();
    	    if(paType.equals("Map<String, Double[]>")) {
    	    	Map<String, Double[]> map=JSONUtil.getMapStrDouArr4Json(value);
            	  obj[i]=map;
    	    }
    	    else  if(paType.equals("Map<String, String[]>")){
    	    	Map<String, String[]> map=JSONUtil.getMapStrStrArr4Json(value);
            	  obj[i]=map;
    	    }
    	    else if(paType.equals("Map<String, int[]>")){
    	    	  Map<String, Integer[]> map=JSONUtil.getMapStrIntArr4Json(value);
            	  obj[i]=map;
    	    }
    	    else if(paType.equals("Map<String, Long[]>")){
    	    	Map<String, Long[]> map=JSONUtil.getMapStrLonArr4Json(value);
    	    	obj[i]=map;
    	    	
    	    }
    	    else  if(paType.equals("Map<String, String>")){
  	    	  Map<String, String> map=JSONUtil.getMapStrStr4Json(value);
          	  obj[i]=map;
  	    }
    	    else if(paType.equals("String")){	
    	    	String str=array.get(i).toString().replaceAll("\"", "");
    	    	obj[i]=str; 	
    	    }
    	    else if(paType.equals("char")){
    	    	 char str=(char)array.getInt(i);
    	    	 obj[i]=str;
    	    }
    	    else if(paType.equals("long")){
    	    	 long str=array.getLong(i);
    	    	 obj[i]=str;
    	    	
    	    }
    	    else  if(paType.equals("int[]")){
    	    	 int[]ar=JSONUtil.getIntArray4Json(value);
				  obj[i]=ar;
    	    }

    	    else  if(paType.equals("Double[]")){
				  Double[] ar=JSONUtil.getDoubleArray4Json(value);
				  obj[i]=ar;
    	    }
    	    else if(paType.equals("String[]")){
				  String[] ar=JSONUtil.getStringArray4Json(value);
				  obj[i]=ar;
    	    }
    	    else if(paType.equals("char[]")){
    	    	char[] ar=JSONUtil.getCharArray4Json(value);
    	    	obj[i]=ar;
    	    	
    	    }
    	    else if(paType.equals("int[][]")){
    	    	int ar[][]=JSONUtil.getDimInt4Json(value);
    	    	obj[i]=ar; 	
    	    }
    	    else if(paType.equals("char[][]")){
    	    	char ar[][]=JSONUtil.getDimChar4Json(value);
    	    	obj[i]=ar;
    	    	
    	    }
    	    else if(paType.equals("Double[][]")){
    	    	Double ar[][]=JSONUtil.getDimDouble4Json(value);
    	    	obj[i]=ar;	
    	    }
    	    else if(paType.equals("String[][]")){
    	    	String ar[][]=JSONUtil.getDimString4Json(value);
    	    	obj[i]=ar;
    	    }
    	    else if(paType.equals("Long[][]")){
    	    	Long ar[][]=JSONUtil.getDimLong4Json(value);
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
}
