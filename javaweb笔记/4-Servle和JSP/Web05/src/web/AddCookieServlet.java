package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cookie c = new Cookie("name", URLEncoder.encode("张迪","utf-8"));
		Cookie c1 = new Cookie("age", URLEncoder.encode("23","utf-8"));
		Cookie c2 = new Cookie("dream", URLEncoder.encode("加油加油加油","utf-8"));
		c.setMaxAge(-1);
		c2.setMaxAge(2147483647);
		response.addCookie(c);
		response.addCookie(c1);
		response.addCookie(c2);
	}

}
