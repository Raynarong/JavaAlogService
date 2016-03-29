package rcpClient;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;


public class Client2 {
	
	public static void main(String[] args) throws Throwable{
		JsonRpcHttpClient client = new JsonRpcHttpClient(

	       //     new URL("http://192.168.0.128:8080/AlogServer_maven/servlet/HelloworldServlet"));
				 new URL("http://192.168.0.56:8080/AlogServer/servlet/HelloworldServlet"));

	        Map<String,String> headers = new HashMap<String,String>();

	        headers.put("name", "剑白");

	     client.setHeaders(headers);
	     String location="Test";
	  //  String location="RpcService.Helloworld";
	   //  String json="[{0:\"nihao\"}]";
	   String json="[]";
//	     String location="RpcService.JavaAdd";
      //   String json="[\"nihao\"]";
	     System.out.println(location);
	     Object[]a={location,json};
	     
	     System.out.println(a[0]);
	     System.out.println(a[1]);
	     Object properties = client.invoke("invokeMethod", a, Object.class);

	        System.out.println(properties);
	} 

}
