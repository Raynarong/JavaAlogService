package Load;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tools.FilePath;

public class PublishVersion extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		String[] input = str.split(";");
		String user_name = input[0];
		String algorithm_name = input[1];
		String version = input[2];
		String fileInPath = FilePath.PublishVersion + user_name + "/" + algorithm_name + "/" + algorithm_name + ".class";
		String fileOutPath = FilePath.PublishVersion + user_name + "/" + algorithm_name + "/" + version + "/" + algorithm_name + ".class";
		String fileMakePath = FilePath.PublishVersion + user_name + "/" + algorithm_name + "/" + version;
		File fileMake = new File(fileMakePath);
		fileMake.mkdirs();
		
		File file_in = new File(fileInPath);
		FileInputStream fin = new FileInputStream(file_in);
		FileChannel in = fin.getChannel();
		
		File file_out = new File(fileOutPath);
		FileOutputStream fout = new FileOutputStream(file_out);
		FileChannel out = fout.getChannel();
		
		in.transferTo(0, in.size(), out);
		
		fin.close();
		in.close();
		fout.close();
		out.close();
		
		PrintWriter pw = arg1.getWriter();
		pw.println("success");
		pw.flush();
		pw.close();
		
	}
	
}
