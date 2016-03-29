package Load;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tools.FilePath;


public class ReturnSource extends HttpServlet {
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		InputStream inputStream = arg0.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String str ="";
		String li=null;
		while(( li= br.readLine()) != null)
		{
			str+=li;
			System.out.println(str);
		}
		
		inputStream.close();
		br.close();
		String savePath=new FilePath().RecievDate;
		String filePath = savePath+str;
		System.out.println(filePath);
		File file_return = new File(filePath);
		InputStream input = new FileInputStream(file_return);
		InputStreamReader ir = new InputStreamReader(input);
		BufferedReader br_return = new BufferedReader(ir);
		String line = null;
	    String str_return = "";
		while((line = br_return.readLine()) != null)
		{
			str_return += line + "<br>";
		}
		System.out.println(str_return);
		if("".equals(str_return))
		{
			str_return = "源码为空";	
		}	
		
		PrintWriter out = arg1.getWriter();
		str_return = URLEncoder.encode(str_return);
		out.println(str_return);
		out.flush();
		out.close();
	}
}

