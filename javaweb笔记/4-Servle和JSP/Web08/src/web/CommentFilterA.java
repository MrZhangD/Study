package web;
//拦截器拦截评论字数超出限制
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilterA implements Filter{

	public CommentFilterA(){
		System.out.println("CommentFilterA的构造器。。。");
	}
	
	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("CommentFilterA开始执行！！！");
		HttpServletRequest request = (HttpServletRequest) arg0 ;
		HttpServletResponse response = (HttpServletResponse) arg1 ;
		request.setCharacterEncoding("utf-8");
		String str = request.getParameter("content");
		response.setContentType("text/html;charset=utf-8");
		if(str.length() > 10){
			PrintWriter out = response.getWriter();
			out.println("<h1 style='color:red;'>你的评论内容字数超出限制<h1>");
			out.close();
		}else{
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("CommentFilterA执行完毕！！！");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("CommentFilterA的初始化。。。");
	}
}
