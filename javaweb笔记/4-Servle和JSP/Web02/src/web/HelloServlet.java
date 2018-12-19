package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//如何写一个Servlet
public class HelloServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request , HttpServletResponse response)
	throws ServletException,IOException{
		//unicode --->gbk,utf-8		编码
		//gbk,utf-8 --->unicode		解码
		//最好先设置编码格式（防止在之后的代码之中出现乱码）
		request.setCharacterEncoding("UTF-8");
		//取出请求参数并处理
		String req = request.getParameter("req");
		String uname[] = request.getParameterValues("uname");
		//设置服务器返回的数据类型
		response.setContentType("text/html;charset=utf-8");
		//输出流
		PrintWriter out = response.getWriter();
		//out默认情况下，会使用"iso-8859-1"来编码
		for(int i = 0 ; i < Integer.parseInt(req) ; i++){
			out.println("<h1>Web02Web02Web02中文中文" + uname[1] + "</h1>");
		}
		out.close();
	}

}
