package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class B extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取servlet上下文
		ServletContext context = getServletContext();
		//读取上下文中绑定的数据
		String str = (String) context.getAttribute("userlist");
		String str1 = context.getInitParameter("全局参数");
		out.println("<h1>获得的servlet的上下文绑定的数据为： " + str + "</h1>");
		out.println("<h1>B读到的初始化参数为： " + str1 + "</h1>");
		out.close();
	}

}
