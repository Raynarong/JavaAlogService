package RpcService;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.jsonrpc4j.JsonRpcServer;

public class HelloworldServlet extends HttpServlet {

	private static final long serialVersionUID = 3638336826344504848L;

    private JsonRpcServer rpcService = null;

    @Override

    public void init(ServletConfig config) throws ServletException {

        super.init(config);

        rpcService = new JsonRpcServer(new HelloWorldService(),HelloWorldService.class);
        System.out.println("远程调用初始化成功");

    }

    @Override
    

    protected void service(HttpServletRequest req, HttpServletResponse resp)

            throws ServletException, IOException {
    	    resp.setHeader("Access-Control-Allow-Origin", "*");
    	    resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            rpcService.handle(req, resp);    

    }


}
