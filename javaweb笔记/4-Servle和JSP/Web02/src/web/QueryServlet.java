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

public class QueryServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request , HttpServletResponse response)
	throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//重新展示在页面（服务器返回的响应数据）不要忘记设置服务器返回的数据类型为text/html
		response.setContentType("text/html");
		
		Connection conn = DatabaseConnect.getConnection();
		String sql = "select * from staff";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			PrintWriter out = response.getWriter();
			out.println("<table style='border: solid 2px #ccc; border-spacing: 0px; width: 40%'><thead><tr>" +
					"<th style='border:solid 2px #ccc;'>name</th>" +
					"<th style='border:solid 2px #ccc;'>salary</th>" +
					"<th style='border:solid 2px #ccc;'>age</th>" +
					"<th style='border:solid 2px #ccc;'>id</th>"+ 
					"<th style='border:solid 2px #ccc;'>功能</th>"+
					"</tr></thead>" );
			out.println("<tbody>");
			while(rs.next()){
				out.println("<tr><td style='border:solid 2px #ccc;'>" + rs.getString(1) + "</td>" +
						"<td style='border:solid 2px #ccc;'>" + rs.getString(2) + "</td>" +
						"<td style='border:solid 2px #ccc;'>" + rs.getString(3) + "</td>" +
						"<td style='border:solid 2px #ccc;'>" + rs.getString(4) + "</td>" +
						"<td style='border:solid 2px #ccc;'>" + "<a href='del?id=" + rs.getInt(4) + "'>删除</a>"+ 
						"&nbsp&nbsp&nbsp" + "<a href='alter?id=" + rs.getInt(4) + "'>修改</a>" + "</td>" +
						"</tr>");
			}
			out.println("</tbody>");
			out.println("</table>");
			out.println("<a href='emp.html'><input type='button' value='添加员工'></a>");
			System.out.println("查询成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询失败，请稍后再试");
			
		}finally{
			DatabaseConnect.close(conn);
		}
		
		
	}
}
