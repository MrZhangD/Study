package pers.zhangdi.practice;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;
import java.util.ResourceBundle;


public class MysqlDemo {
	public static void main(String[] args) throws Exception {
		//下面两种连接方式，一种不读取配置文件，另一种使用配置文件
//		Class.forName("com.mysql.jdbc.Driver") ;
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?user=root&password=199612&useUnicode=true&characterEncoding=utf-8") ;
		
		//中间插一句：使用Vector子类Properties类来读取配置文件中的属性
		Properties pro = new Properties() ;
		pro.load(new FileInputStream("src/sql.properties"));
		String url = pro.getProperty("url") ;
		String driver = pro.getProperty("driver") ;
		
//		ResourceBundle bundle = ResourceBundle.getBundle("sql") ;		//读取配置文件 sql.properties 中的参数 
//		String url = bundle.getString("url") ;
//		String driver = bundle.getString("driver") ;
		
		Class.forName(driver) ;			//加载驱动
		Connection conn = DriverManager.getConnection(url) ;		//连接数据库
		
		//操纵数据库
		PreparedStatement ps = null ;
		ResultSet rs = null ;		//结果集，获得执行结果的
		ResultSetMetaData md = null ;		//记录查询到的结果的表本身的信息，如列数，列名····
		String sql = "SELECT * FROM thebook WHERE book_name = ?" ;
		ps = conn.prepareStatement(sql) ;
		ps.setString(1, "中国人民解放军");
		rs = ps.executeQuery() ;
		md = rs.getMetaData();
		if(rs.next()) {
			for(int i = 1 ; i <= md.getColumnCount() ; i++) {
				System.out.print(md.getColumnName(i) + "--:-->");
				System.out.println(rs.getString(i));	//输出查询到的所有列的信息
			}
		}
		ps.close();
		rs.close();
		conn.close();
	}
}
