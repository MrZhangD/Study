package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//写一个DateServlet。输出当前的系统时间（http://ip:port/web01/date）
public class DateServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request , HttpServletResponse response)
	throws ServletException , IOException{
		//向页面写内容，需要设置编码格式为UTF-8
		response.setCharacterEncoding("utf-8");
		//服务器给客户端返回一个html文件
		response.setContentType("text/html");
		//创建一个输出流
		PrintWriter out = response.getWriter();
		//获取系统时间并且格式化
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String time = sdf.format(date);
		out.println("<h1>Web02" + time + "</h1>");
		out.close();
	}
}
