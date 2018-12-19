package pers.zhangdi.dbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//数据库连接类
//本类专门负责数据库的连接与关闭操作，在实例化本类对象时就意味着要进行数据库的开发
//在本类中要建一个方法：进行数据库驱动的加载和数据库的连接取得

public class DatabaseConnection {
	private Properties pro = null ;
	private Connection conn = null ;
	private String url ;
	private String driver ;
	
	//负责数据库的连接操作，外部从此取得数据库的连接对象
	public Connection getConnection() {
		try {
		pro = new Properties() ;
		pro.load(new FileInputStream("src/dbc.properties"));
		url = pro.getProperty("url") ;
		driver = pro.getProperty("driver") ;
		
		Class.forName(driver) ;		//加载驱动
		this.conn = DriverManager.getConnection(url) ;		//连接数据库
		}catch(Exception e) {
			e.printStackTrace();
		}
		return this.conn ;
	}
	
	//负责数据库的关闭
	public void close() {
		if(this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
