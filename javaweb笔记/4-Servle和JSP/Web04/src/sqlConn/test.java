package sqlConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
	public static void main(String[] args) {
		Connection conn = DatabaseConnect.getConnection();
		
//		String sql = "select * from staff";
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()){
//				System.out.print("姓名：" + rs.getString("name") + "  ");
//				System.out.print("薪水：" + rs.getString("salary") + "  ");
//				System.out.print("年龄：" + rs.getString("age") + "  ");
//				System.out.println("id：" + rs.getString("id"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("查询失败！");
//		}finally{
//			DatabaseConnect.close(conn);
//		}
		
//		String sql = "select count(*) from staff";
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			rs.next();
//			int max = rs.getInt(1);
//			System.out.println(max+1);
//					
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			DatabaseConnect.close(conn);
//		}
//		
		String sql = "select * from staff where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 5);
			ResultSet rs = ps.executeQuery();
			rs.next();
			System.out.println(rs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
