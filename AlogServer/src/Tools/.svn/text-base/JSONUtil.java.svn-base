package Tools;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtil {
	/**
	 * 从json数组中解析出字符串数组
	 * @param jsonString
	 * @return
	 */
	  public static String[] getStringArray4Json(String jsonString) {  
		  
	        JSONArray jsonArray = JSONArray.fromObject(jsonString);  
	        String[] stringArray = new String[jsonArray.size()];  
	        for (int i = 0; i < jsonArray.size(); i++) {  
	            stringArray[i] = jsonArray.getString(i);  
	        }  
	        return stringArray;  
	    }
	  
	  /**
	   * 从json数组中解析出long数组
	   * @param jsonString
	   * @return
	   */
	  public static Long[] getLongArray4Json(String jsonString) {  
		  
	        JSONArray jsonArray = JSONArray.fromObject(jsonString);  
	        Long[] longArray = new Long[jsonArray.size()];  
	        for (int i = 0; i < jsonArray.size(); i++) {  
	            longArray[i] = jsonArray.getLong(i);  
	        }  
	        return longArray;  
	    } 
	  
	  /**
	   * 从json数组数组中解析出Integer数组
	   * @param jsonString
	   * @return
	   */
	  public static Integer[] getIntegerArray4Json(String jsonString) {  
		  
	        JSONArray jsonArray = JSONArray.fromObject(jsonString);  
	        Integer[] integerArray = new Integer[jsonArray.size()];  
	        for (int i = 0; i < jsonArray.size(); i++) {  
	            integerArray[i] = jsonArray.getInt(i);  
	        }  
	        return integerArray;  
	    }  
	  
	/**
	 * 从json数组数组中解析出int数组
	 * @param jsonString
	 * @return
	 */
	  public static int[] getIntArray4Json(String jsonString) {  
		  
	        JSONArray jsonArray = JSONArray.fromObject(jsonString);  
	        int[] intArray = new int[jsonArray.size()];  
	        for (int i = 0; i < jsonArray.size(); i++) {  
	            intArray[i] = jsonArray.getInt(i);  
	        }  
	        return intArray;  
	    }
	  
	  /*//从json数组中解析出java Date型对象数组
	  public static Date[] getDateArray4Json(String jsonString, String DataFormat) {  
		  
	        JSONArray jsonArray = JSONArray.fromObject(jsonString);  
	        Date[] dateArray = new Date[jsonArray.size()];  
	        String dateString;  
	        Date date;  
	        for (int i = 0; i < jsonArray.size(); i++) {  
	            dateString = jsonArray.getString(i);  
	            date = DateUtil.stringToDate(dateString, DataFormat);  
	            dateArray[i] = date;  
	        }  
	        return dateArray;  
	    } */
	  
	 
	  /**
	   * 从json数组中解析出Double数组
	   */
	  public static Double[] getDoubleArray4Json(String jsonString) {  
		  
	        JSONArray jsonArray = JSONArray.fromObject(jsonString);  
	        Double[] doubleArray = new Double[jsonArray.size()];  
	        for (int i = 0; i < jsonArray.size(); i++) {  
	            doubleArray[i] = jsonArray.getDouble(i);  
	        }  
	        return doubleArray;  
	    }
	  
	  /**
	   * 从json数组中解析出char数组
	   * @param jsonString
	   * @return
	   */
	  public static char[] getCharArray4Json(String jsonString){
		  JSONArray jsonArray = JSONArray.fromObject(jsonString);  
	        char[] charArray = new char[jsonArray.size()];  
	        for (int i = 0; i < jsonArray.size(); i++) {  
	            charArray[i] = (char) jsonArray.getInt(i);  
	        }  
	        return charArray;  
	  }
	  
	  /**
	   * 从json数组中解析出Map<String, Double[]>
	   * @param jsonString
	   * @return
	   */
	  
	  public static Map<String, Double[]> getMapStrDouArr4Json(String jsonString){
		  Map<String, Double[]> map=new HashMap<String, Double[]>();
    	  JSONObject inArrer= JSONObject.fromObject(jsonString);
    	  Iterator keys=inArrer.keys();
    	  while(keys.hasNext()){
    		  String s=keys.next().toString();
     		 System.out.println(s);
     		 String value=inArrer.get(s).toString();
     		/*JSONArray inArr=JSONArray.fromObject(value);
     		 Double[] ar=new Double[inArr.size()]; 
			  for(int ii=0;ii<inArr.size();ii++){
				  ar[ii]=inArr.getDouble(ii);
			  }*/
     		 Double[] ar=JSONUtil.getDoubleArray4Json(value); 
			 map.put(s, ar);
    	  }
    	  return map;
		  
	  }
	  
	  /**
	   * 从json数组中解析出Map<String, Int[]>
	   * @param jsonString
	   * @return
	   */
	  
      public static Map<String, Integer[]> getMapStrIntArr4Json(String jsonString){
    	  Map<String, Integer[]> map=new HashMap<String, Integer[]>();
    	  JSONObject inArrer= JSONObject.fromObject(jsonString);
    	  Iterator keys=inArrer.keys();
    	  while(keys.hasNext()){
    		  String s=keys.next().toString();
     		 System.out.println(s);
     		 String value=inArrer.get(s).toString();
     		/*JSONArray inArr=JSONArray.fromObject(value);
     		 int[] ar=new int[inArr.size()]; //暂时写为DOuble；
			  for(int ii=0;ii<inArr.size();ii++){
				  ar[ii]=inArr.getInt(ii);
			  }
			  */
     		 Integer[] ar=JSONUtil.getIntegerArray4Json(value);
			 map.put(s, ar);  
	   }
    	  return map;
      }
      
      /**
       * 从json数组中解析出Map<String, Long[]>
       * @param jsonString
       * @return
       */
      public static Map<String, Long[]> getMapStrLonArr4Json(String jsonString){
    	  Map<String, Long[]> map=new HashMap<String, Long[]>();
    	  JSONObject inArrer= JSONObject.fromObject(jsonString);
    	  Iterator keys=inArrer.keys();
    	  while(keys.hasNext()){
    		  String s=keys.next().toString();
     		 System.out.println(s);
     		 String value=inArrer.get(s).toString();
     		/*JSONArray inArr=JSONArray.fromObject(value);
     		 int[] ar=new int[inArr.size()]; //暂时写为DOuble；
			  for(int ii=0;ii<inArr.size();ii++){
				  ar[ii]=inArr.getInt(ii);
			  }
			  */
     		 Long[] ar=JSONUtil.getLongArray4Json(value);
			 map.put(s, ar);  
	   }
    	  return map;
      }
      
      
      /**
       * 从json数组中解析出Map<String, String[]>
       * @param jsonString
       * @return
       */
      public static Map<String, String[]> getMapStrStrArr4Json(String jsonString){
    	  Map<String, String[]> map=new HashMap<String, String[]>();
    	  JSONObject inArrer= JSONObject.fromObject(jsonString);
    	  Iterator keys=inArrer.keys();
    	  while(keys.hasNext()){
    		  String s=keys.next().toString();
     		 System.out.println(s);
     		 String value=inArrer.get(s).toString();
     		/*JSONArray inArr=JSONArray.fromObject(value);
     		 int[] ar=new int[inArr.size()]; //暂时写为DOuble；
			  for(int ii=0;ii<inArr.size();ii++){
				  ar[ii]=inArr.getInt(ii);
			  }
			  */
     		 String[] ar=JSONUtil.getStringArray4Json(value);
			 map.put(s, ar);  
	   }
    	  return map;
	  
      }
      
      /**
       * 从json数组中解析出Map<String, String>
       * @param jsonString
       * @return
       */
      public static Map<String, String> getMapStrStr4Json(String jsonString){
    	  Map<String, String> map=new HashMap<String, String>();
    	  JSONObject inArrer= JSONObject.fromObject(jsonString);
    	  Iterator keys=inArrer.keys();
    	  while(keys.hasNext()){
    		  String s=keys.next().toString();
     		 System.out.println(s);
     		 String value=inArrer.get(s).toString();
     		/*JSONArray inArr=JSONArray.fromObject(value);
     		 int[] ar=new int[inArr.size()]; //暂时写为DOuble；
			  for(int ii=0;ii<inArr.size();ii++){
				  ar[ii]=inArr.getInt(ii);
			  }
			  */
     		// Integer[] ar=JSONUtil.getIntegerArray4Json(value);
			 map.put(s, value);  
	   }
    	  return map;
       }
      
      /**
       * 从json中解析出多维int数组
       * @param jsonString
       * @return
       */
      public static int[][] getDimInt4Json(String jsonString){
    	  JSONArray array=JSONArray.fromObject(jsonString);
    	  int[][] DimInt=new int[array.size()][];
    	  for(int i=0;i<array.size();i++){
    		  DimInt[i]=JSONUtil.getIntArray4Json(array.get(i).toString());	  
    	  }
    	  return DimInt;
      }
      
      /**
       * 从json中解析出多维char数组
       * @param jsonString
       * @return
       */
      
      public static char[][] getDimChar4Json(String jsonString){
    	  JSONArray array=JSONArray.fromObject(jsonString);
    	  char[][] DimChar=new char[array.size()][];
    	  for(int i=0;i<array.size();i++){
    		  DimChar[i]=JSONUtil.getCharArray4Json(array.get(i).toString());	  
    	  }
    	  return DimChar;
      }
      
      /**
       * 从json中解析出多维Double数组
       * @param jsonString
       * @return
       */
      public static Double[][] getDimDouble4Json(String jsonString){
    	  JSONArray array=JSONArray.fromObject(jsonString);
    	  System.out.println(jsonString);
    	  Double[][] DimDouble=new Double[array.size()][];
    	  System.out.println("array.size:"+array.size());
    	  for(int i=0;i<array.size();i++){
    		  System.out.println(array.getString(i));
    		  DimDouble[i]=JSONUtil.getDoubleArray4Json(array.get(i).toString());	
    		
    	  }
    	  return DimDouble;
      }
      
      /**
       * 从json中解析出多维String数组
       * @param jsonString
       * @return
       */
      public static String[][] getDimString4Json(String jsonString){
    	  JSONArray array=JSONArray.fromObject(jsonString);
    	  String[][] DimString=new String[array.size()][];
    	  for(int i=0;i<array.size();i++){
    		  DimString[i]=JSONUtil.getStringArray4Json(array.get(i).toString());	  
    	  }
    	  return DimString;
      }
      
      /**
       * 从json中解析出多维long数组
       * @param jsonString
       * @return
       */
      public static Long[][] getDimLong4Json(String jsonString){
    	  JSONArray array=JSONArray.fromObject(jsonString);
    	  Long[][] DimLong=new Long[array.size()][];
    	  for(int i=0;i<array.size();i++){
    		  DimLong[i]=JSONUtil.getLongArray4Json(array.get(i).toString());	  
    	  }
    	  return DimLong;
      }
      
      /**
       * my test
       * @param args
       */
	  public static void main(String args[]){
		  String a="[[[1,2,3],[7,8]],[4,5,6]]";
		  JSONArray array = JSONArray.fromObject(a);
		  for(int i=0;i<array.size();i++){
			  System.out.println(array.get(i).toString());  
			  System.out.println(array.getString(i)); 
			  
		  }
		  int[][] DimInt=getDimInt4Json(array.get(0).toString());
		  for(int i=0;i<DimInt.length;i++){
			  for(int index=0;index<DimInt[i].length;index++){
				  System.out.print(DimInt[i][index]+" ");
			  }
			  System.out.println("\n");
		  }
	  }
}
