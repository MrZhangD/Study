package pers.zhangdi.dbcp;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;

public class DBConn {
	public static void main(String[] args)throws Exception {
		Properties pro = new Properties() ;
		pro.load(new FileInputStream("src/dbcp.properties")) ;		//将配置文件加载进pro对象
		//BasicDataSource 是DBCP的核心连接池 ， BasicDataSource 实现了DataSource这个接口
		//返回javax.sql.DataSource 的实现类
		DataSource ds = BasicDataSourceFactory.createDataSource(pro) ;
		System.out.println("+++++++++++");
			
		//其余的地方，正常使用JDBC连接
		Connection con = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		ResultSetMetaData md = null ;
		
		con = ds.getConnection() ;
		String sql = "SELECT * FROM thebook WHERE book_name = ?" ;
		ps = con.prepareStatement(sql) ;
		ps.setString(1, "中国人民解放军");
		rs = ps.executeQuery() ;
		md = rs.getMetaData();
		if(rs.next()) {
			for(int i = 1 ; i <= md.getColumnCount() ; i++) {
				System.out.print(md.getColumnName(i) + "--:-->");
				System.out.println(rs.getString(i));	//输出查询到的所有列的信息
			}
		}
	}
}
