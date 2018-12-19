package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sqlConn.DatabaseConnect;

public class ModifyServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request , HttpServletResponse response)
	throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		String id = request.getParameter("id");
		Connection conn = DatabaseConnect.getConnection();
		String sql = "update staff set name=?,salary=?,age=? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setFloat(2, Float.parseFloat(salary));
			ps.setInt(3, Integer.parseInt(age));
			ps.setInt(4, Integer.parseInt(id));
			if(ps.executeUpdate() != 0){
				System.out.println("修改成功！！");
			}
			response.sendRedirect("query");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("系统错误，修改失败！！");
		}finally{
			DatabaseConnect.close(conn);
		}
		
	}
}
