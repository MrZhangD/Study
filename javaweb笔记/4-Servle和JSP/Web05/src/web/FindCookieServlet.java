package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCookieServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(int i = 0 ; i < cookies.length ; i++){
				out.print("<h1>cookie" + i + "'s name:" + cookies[i].getName() + "----------");
				out.println("cookie" + i + "'s value:" + URLDecoder.decode(cookies[i].getValue(), "utf-8") + "</h1>");
			}
		}else{
			out.println("<h1>找不到任何Cookie！！");
		}
		out.close();
	}
}
