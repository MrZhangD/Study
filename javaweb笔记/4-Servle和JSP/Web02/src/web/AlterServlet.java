package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sqlConn.DatabaseConnect;

public class AlterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request , HttpServletResponse response)
	throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		//先生成一个修改信息的页面
		String id = request.getParameter("id");
		Connection conn = DatabaseConnect.getConnection();
		String sql = "select * from staff where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			ResultSet rs = ps.executeQuery();
			PrintWriter out = response.getWriter();
			if(rs.next()){
				out.println("ID: " + id + "<br>" + "<h1>信息修改</h1>");
				out.println("<form action='modify' method='post'>");
				out.println("姓名: <input type='text' name='name' value='" + rs.getString(1) +"'><br>");
				out.println("薪水: <input type='text' name='salary' value='" + rs.getFloat(2) +"'><br>");
				out.println("年龄: <input type='text' name='age' value='" + rs.getInt(3) +"'><br><br>");
				out.println("年龄: <input type='hidden' name='id' value='" + rs.getInt(4) +"'><br><br>");
			}
			out.println("<input type='submit' value='确定修改'>" + "&nbsp&nbsp&nbsp");
			out.println("<a href='query'><input type='button' value='查询全部'></a><br>");
			out.println("</form>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("系统出错，请稍后再试！！");
		}finally{
			DatabaseConnect.close(conn);
		}
		
		//修改信息确认
	}
}
