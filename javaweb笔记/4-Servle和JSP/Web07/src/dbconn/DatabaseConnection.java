package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {
	private static String url ;
	private static String driver ;
	private static Connection conn = null ;
	private static ResourceBundle bundle = null ;
	
	public static void Read(){
		bundle = ResourceBundle.getBundle("sql");
		driver = bundle.getString("driver");
		url = bundle.getString("url");
	}
	
	public static void Connect(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Read();
		Connect();
		return conn ;
	}
	
	public static void close(){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
