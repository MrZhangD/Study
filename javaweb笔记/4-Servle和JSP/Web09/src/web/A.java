package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class A extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取上下文
		ServletContext context = getServletContext();
		//绑定数据到上下文
		context.setAttribute("userlist", "张三，李四，王五");
		String str = context.getInitParameter("全局参数");
		out.println("<h1>成功向servlet上下文绑定数据！！<h1>");
		out.println("<h1>A读到的初始化参数为：" + str + "</h1>");
		out.close();
	}
}
