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
//		//读取请求参数值
//		String num = request.getParameter("num");
//		String str = "";
//		for(int i = 0 ; i < Integer.parseInt(num) ; i++){
//			str = str + "<h1>Hello , Servlet</h1>";
//		}
		//计算一个人的bim指数，计算规则 bmi=体重（千克）/身高（米）/身高（米）
		//读取请求参数
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");
		double bmi = Double.parseDouble(weight)/Double.parseDouble(height)/Double.parseDouble(height);
		//服务器要给客户端返回一个html的文档
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		//输出流
		PrintWriter out = response.getWriter();
		out.println("<h1> 你的bim指数为：" + bmi + "</h1>");
		out.println("<h1> 你的bim指数为：" + bmi + "</h1>");
		out.close();
	}

}
