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

public class DelServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request , HttpServletResponse response)
	throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		Connection conn  = DatabaseConnect.getConnection();
		String sql = "delete from staff where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id)) ;
			if(ps.executeUpdate() !=0){
				System.out.println("删除id为" + id + "的人员信息：成功！");
			}
			response.sendRedirect("query");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("删除id为" + id + "的数据：失败！");
		}finally{
			DatabaseConnect.close(conn);
		}
	}
}
