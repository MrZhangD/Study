package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sqlConn.DatabaseConnect;

public class AddEmpServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request , HttpServletResponse response)
			throws ServletException , IOException {
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取页面传入的数据
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		@SuppressWarnings("unused")
		String id = request.getParameter("id");
		//重新展示在页面（服务器返回的响应数据）不要忘记设置服务器返回的数据类型为text/html
		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<h1>姓名 ：" + name + "</h1>" + "<h1>薪水 ：" + salary + "</h1>" +
//				"<h1>年龄 ：" + age + "</h1>" + "<h1>id：" + id + "</h1>");
//		out.println("<form action='query' method='post'><input type='submit' value='查询' ></form>");
//		out.close();
		
		//将数据插入到数据库中
		//1、得到数据库连接
		Connection conn = DatabaseConnect.getConnection();
		//2、使用PreparedStatement插入数据
		String sql1 = "select count(*) from staff";
		int max = 1;
		try {
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()){
				max = rs1.getInt(1) + 1;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql= "insert into staff values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setFloat(2, Float.parseFloat(salary));
			ps.setInt(3, Integer.parseInt(age));
			ps.setInt(4,max);
			
			if(ps.executeUpdate() != 0){
				System.out.println("插入成功！！");
				//重定向
				response.sendRedirect("query");	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("插入失败！！");
		}finally{
			//无论如何最后一定要关闭数据库接口
			DatabaseConnect.close(conn);
		}
	}
}
