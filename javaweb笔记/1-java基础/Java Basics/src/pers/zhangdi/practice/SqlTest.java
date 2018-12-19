package pers.zhangdi.practice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;



public class SqlTest {
	public static void main(String[] args) {
		
		Connection conn = MysqlConnect.getConnection() ;	//获得可以操作数据库的入口
		PreparedStatement ps = null ;				
		CallableStatement call = null ;
		ResultSet rs = null ;
		ResultSetMetaData md = null ;
		String sql = "insert into thebook values(?,?,?,?,?,?,?,?)" ;
			
		try {
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, "bbb");
			ps.setString(2, "bbb");
			ps.setString(3, "bbb");
			ps.setString(4, null);
			ps.setString(5, "88888888");
			ps.setInt(6, 8);
			ps.setInt(7, 0);
			ps.setTimestamp(8, new Timestamp((new Date()).getTime()));
			
			int j = ps.executeUpdate() ;
			if(j > 0) {
					System.out.println("添加成功");
			}else {
				System.out.println("添加失败");
			}
//			//执行存储过程
//			String s = "call proc_borrow(?,?,?,?)" ;
//			call = conn.prepareCall(s) ;
//			call.setString(1, "39021");
//			call.setString(2, "201511010106");
//			call.setTimestamp(3, new Timestamp((new Date()).getTime()));	//注意java与mysql中时间类型的对应
//			call.registerOutParameter(4, java.sql.Types.VARCHAR);;			//获取存储过程中的返回值
//			boolean flag = call.execute() ;			//执行存储过程语句
//			if(flag)
//				System.out.println(call.getString(4));
//			else
//				System.out.println("借书失败");
//			//查询表中数据
//			String sql = "select * from borrow_record where reader_id = ?" ;
//			ps = conn.prepareStatement(sql) ;
//			ps.setString(1, "201511010106");
//			rs = ps.executeQuery() ;
//			md = rs.getMetaData() ;
//			while(rs.next()) {
//				for(int i = 1 ; i < (md.getColumnCount()+1) ; i++) {
//					System.out.print(md.getColumnName(i) + "\t");
//					System.out.println(rs.getString(i));
//				}
//			}
			
//			//查询数据库
//			String sql = "select * from readers where reader_name = ?" ;		//要执行的sql语句
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, "张三");	 		//设置给sql语句中第一个问号的值为String类型的“张迪”
//			rs = ps.executeQuery() ;		//执行sql语句并且获得执行后的结果集
//			md= rs.getMetaData() ;		//获取所执行sql语句的表的列名
//			while(rs.next()) {
//				for(int i = 1 ; i < 8 ; i++) {
//					System.out.print(pp(md.getColumnName(i)));
//					System.out.println(rs.getString(i));	
//				}
//			}
			
//			//修改（更新）数据库中的数据 ，DML语句update insert delete 
//			String sql1 = "update readers set reader_sex = ? , reader_age = ? , reader_pro = ? , reader_grade = ? where reader_name = ?" ;
//			ps = conn.prepareStatement(sql1) ;
//			ps.setString(1, "女");
//			ps.setInt(2, 30);
//			ps.setString(3, "文学院");
//			ps.setString(4, "研一");
//			ps.setString(5, "张三");
//			int j = ps.executeUpdate() ;		//ps.executeUpdate()执行DML语句返回int值（修改的行数），
//			if(j > 0)
//				System.out.println("更新数据成功！");
//			else
//				System.out.println("更新数据失败！");
//			
//			//再次查询数据库
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, "张三");	 		//设置给sql语句中第一个问号的值为String类型的“张迪”
//			rs = ps.executeQuery() ;		//执行sql语句获得执行后的结果集
//			md= rs.getMetaData() ;		//获取所执行sql语句的表的列名
//			
//			while(rs.next()) {
//				for(int i = 1 ; i < 8 ; i++) {
//					System.out.print(pp(md.getColumnName(i)));
//					System.out.println(rs.getString(i));	
//				}
//			}
			
			
			//修改表结构，DDL语句	create alter drop truncate
//			String sql2 = "create table Test (test1 int not null , test2 varchar(20) not null , test3 char(10) primary key not null) " ;
//			ps = conn.prepareStatement(sql2) ;
//			int m = ps.executeUpdate() ;		//ps.executeUpdate()执行DDL语句返回int 0
//			if(m == 0)
//				System.out.println("更新表结构成功！");
//			else
//				System.out.println("更新表结构失败！");
//			
//			//删除表中的某一列（属于DDL语句）
//			String sql2 = "drop table Test" ;
//			ps = conn.prepareStatement(sql2) ;
//			int m = ps.executeUpdate() ;
//			if(m == 0) 
//				System.out.println("更新表结构成功！");
//			else
//				System.out.println("更新表结构失败！");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
            if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            System.out.println("成功关闭资源");
        }
	}
	public static String pp(String p) {
		if(p.contains("id"))
			return ("借书证号：" + "\t");
		if(p.contains("name"))
			return("姓名：" + "\t");
		if(p.contains("sex"))
			return("性别：" + "\t");
		if(p.contains("age"))
			return("年龄：" + "\t");
		if(p.contains("pro"))
			return("专业：" + "\t");
		if(p.contains("grade"))
			return("年级：" + "\t");
		if(p.contains("pass")) 
			return("密码：" + "\t");
		else
			return null ;
	}
}
