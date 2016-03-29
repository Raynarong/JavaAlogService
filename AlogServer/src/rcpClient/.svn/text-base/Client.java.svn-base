package rcpClient;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;


public class Client {
	
	public static void main(String[] args) throws Throwable{
		JsonRpcHttpClient client = new JsonRpcHttpClient(

	       //     new URL("http://192.168.0.128:8080/AlogServer_maven/servlet/HelloworldServlet"));
				 new URL("http://192.168.0.56:8080/AlogServer/servlet/HelloworldServlet"));

	        Map<String,String> headers = new HashMap<String,String>();

	        headers.put("name", "剑白");

	     client.setHeaders(headers);
	     String location="Raynarong.myTestDemo.myTestDemo";
	  //  String location="RpcService.Helloworld";
	   //  String json="[{0:\"nihao\"}]";
	   String json="[[7,2,5,1,0,9]]";
//	     String location="RpcService.JavaAdd";
      //   String json="[\"nihao\"]";
	     System.out.println(location);
	     Object[]a={location,json};
	     Object[]b={location};
	     System.out.println(a[0]);
	     System.out.println(a[1]);
	//     Object properties = client.invoke("invokeMethod", a, Object.class);
	     Object prop = client.invoke("ReturnParaMeter", b, Object.class);

	        System.out.println(prop);
	} 

}
