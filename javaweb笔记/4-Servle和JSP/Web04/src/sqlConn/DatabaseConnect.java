package sqlConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnect {
	//声明属性
	private static String driver ;
	private static String url ;
	private static Connection conn= null ;
	private static ResourceBundle bundle = null;	//使用ResourceBundle读取配置文件
	
	//读取配置文件中的属性driver和url
	public static void MysqlRead(){
		bundle = ResourceBundle.getBundle("sql");	//配置文件的位置
		//搜索配置文件中的属性并且赋值
		driver = bundle.getString("driver");
		url = bundle.getString("url");
	}
	
	//连接数据库的方法
	public static void Connect(){
		try {
			Class.forName(driver);			//加载驱动
			conn = DriverManager.getConnection(url);	//连接数据库（此时conn相当于连接数据库一个接口，所有操作数据库的都从conn下手）
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//外界从此方法中获取conn（即数据库的接口）
	public static Connection getConnection(){
		MysqlRead();
		Connect();
		return conn;
	}
	
	//关闭数据资源库
	public static void close(Connection conn){
		if(conn != null){		//当conn不为空时
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("关闭数据库时出现异常");
			}
		}
	}
}
