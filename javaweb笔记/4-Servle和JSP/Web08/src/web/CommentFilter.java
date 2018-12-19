package web;
//拦截器拦截评论敏感字
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

public class CommentFilter implements Filter {
	private FilterConfig config;
	//容器启动后，会立即创建过滤器对象。只会创建一个
	public CommentFilter() {
		System.out.println("CommentFilter的构造器。。。");
	}

	public void destroy() {
	}

	/**
	 * 容器调用doFilter方法来处理请求
	 * 容器会将request和response作为参数传递过来
	 * FilterChain（过滤器链）
	 * 如果调用了FilterChain的doFile方法，则容器会继续向后调用
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("CommentFilter开始执行！！！");
		System.out.println("CommentFilter获得的初始化参数：" + config.getInitParameter("illegalStr"));
		//要进行强制转换
		HttpServletRequest request = (HttpServletRequest) arg0 ;
		HttpServletResponse response = (HttpServletResponse) arg1 ;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String content = request.getParameter("content");
		if(content.contains(config.getInitParameter("illegalStr"))){
			//包含敏感字
			PrintWriter out = response.getWriter();
			out.print("<h1 style='color:red;'>您的评论包含敏感字</h1>");
			out.close();
		}
		else{
			//继续向后调用
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("CommentFilter执行完毕！！！");
	}

	//容器在创建好过滤器对象之后，接下来会调用该对象的init方法，该方法只会执行一次
	public void init(FilterConfig arg0) throws ServletException {
		//将容器传递过来的FilterConfig对象保存下来
		//并且提供了一个获得该对象的一个方法
		config = arg0;
		System.out.println("CommentFilter的初始化。。。");
	}

}
