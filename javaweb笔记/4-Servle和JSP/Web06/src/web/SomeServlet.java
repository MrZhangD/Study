package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SomeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		//设置超时时间
		session.setMaxInactiveInterval(30);
		Integer count = (Integer) session.getAttribute("count");
		if(count == null){
			//第一次访问
			count = 1;
		}else{
			//不是第一次
			count++;
		}
		session.setAttribute("count", count);
		session.setAttribute("name", "zhangdi");
		
		PrintWriter out = response.getWriter();
		out.print("count : " + session.getAttribute("count") + "------");
		out.print("sessionId : " + session.getId() + "------");
		out.println("name:" + session.getAttribute("name"));
		//删除session
		session.invalidate();
		out.close();
	}
}
