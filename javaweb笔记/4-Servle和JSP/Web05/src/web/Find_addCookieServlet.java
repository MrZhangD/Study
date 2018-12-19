package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Find_addCookieServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			boolean flag = false ;
			for(int i = 0 ; i < cookies.length ; i++){
				if("items".equals(cookies[i].getName())){
					PrintWriter out = response.getWriter();
					out.print("<h1>cookie" + i + "'s name:" + cookies[i].getName() + "----------");
					out.println("cookie" + i + "'s value:" + URLDecoder.decode(cookies[i].getValue(), "utf-8") + "</h1>");
					flag = true ;
					out.close(); 
				}
			}
			if(!flag){
				Cookie c = new Cookie("items" , URLEncoder.encode("因为没有所以新建的item", "utf-8"));
				response.addCookie(c);
			}
		}else{
			Cookie c = new Cookie("items" , URLEncoder.encode("因为没有所以新建的item", "utf-8"));
			response.addCookie(c);
		}
	}
}
