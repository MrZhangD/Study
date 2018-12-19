package pers.zhangdi.test;

import java.io.FileInputStream;
import java.util.Properties;

public class ConnTest {
	public static void main(String[] args) throws Exception {
		Properties pro = new Properties() ;
		pro.load(new FileInputStream("src/dbc.properties"));
		String url = pro.getProperty("url") ;
		System.out.println(url);
		System.out.println(pro.getProperty("driver", "失败"));
	}
}
