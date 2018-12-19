package pers.zhangdi.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesDemo {
	public static void main(String[] args)throws Exception {
		Properties pro = new Properties() ;
		pro.setProperty("姓名", "张迪") ;
		pro.setProperty("性别", "男") ;
		pro.setProperty("年龄", "22") ;
		System.out.println(pro.getProperty("年龄"));
		System.out.println(pro.getProperty("性别"));
		System.out.println(pro.getProperty("姓名"));
		System.out.println(pro.getProperty("姓名1" , "对不起，查找不到！"));
		//在Properties类中提供有数据的输出操作 
		//public void store(OutputStream out , String comments)throws IOException
		//D:\Workspaces\Eclipse\Java Basics\src\pro.properties
		pro.store(new FileOutputStream(new File("D:" + File.separator + "Workspaces" + File.separator + "Eclipse" + 
		File.separator + "Java Basics" + File.separator + "src" + File.separator + "pro.properties")), "zd");
		//从指定的输入流中读取属性信息： public void load(InputStream input)throws IOException
		Properties pro1 = new Properties() ;
		pro1.load(new FileInputStream(new File("D:" + File.separator + "Workspaces" + File.separator + "Eclipse" + 
				File.separator + "Java Basics" + File.separator + "src" + File.separator + "sql.properties")));
		System.out.println("url : " + pro1.getProperty("url", "error"));
		System.out.println("driver : " + pro1.getProperty("driver", "error"));
		//通过ResourceBundle类来读取配置文件
		ResourceBundle bundle = ResourceBundle.getBundle("sql") ;
		System.out.println("URL = " + bundle.getString("url"));
		System.out.println("DRIVER = " + bundle.getString("driver"));
		
	}
}
