package pers.zhangdi.practice;
//读取配置文件中的属性

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MysqlConnect {
	//声明属性
	private static String driver ;
	private static String url ;
	private static Connection conn = null ;
	private static ResourceBundle bundle = null ;		//使用ResourceBundle来读取配置文件
	
	//读取配置文件中的属性的方法
	public static void MysqlReade() {
		try {
			bundle = ResourceBundle.getBundle("sql") ;   //配置文件的位置
			
			MysqlConnect.driver = bundle.getString("driver") ;		//搜索属性并赋值
			MysqlConnect.url = bundle.getString("url") ;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//连接数据库的方法
	public static void Connect() {	
		try{
			Class.forName(driver) ;			//加载驱动
			conn = DriverManager.getConnection(url);	//连接数据库(此时conn相当于连接数据库的一个接口，所有操作数据库的都从conn下手)
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//外界从此方法中获取conn
	public static Connection getConnection() {
		MysqlConnect.MysqlReade();
		MysqlConnect.Connect();
		return MysqlConnect.conn ;
	}
	
	//关闭数据库资源
	public static void close(Connection conn){
        if(conn!=null)
        {
            try {
                conn.close();
                System.out.println("成功关闭资源");
            } catch (SQLException e) {
                System.out.println("SQL异常");
            }
        }
    }
}
