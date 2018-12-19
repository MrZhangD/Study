package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//构造方法
	public SomeServlet(){
		System.out.println("这是SomeServlet的构造方法...");
	}	
	
	@Override
	//覆写init初始化方法
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("这是覆写的init初始化方法");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("这里是doGet()。。。。即将要调用doPost()方法");
		doPost(req , resp);
	}
	
	@Override
	public void doPost(HttpServletRequest request , HttpServletResponse response)
	throws ServletException , IOException{
		System.out.println("这是SomeServlet的doPost方法...");
		ServletConfig config = getServletConfig();
		String school = config.getInitParameter("school");
		System.out.println(school);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁该Servlet！！");
	}
	
}
