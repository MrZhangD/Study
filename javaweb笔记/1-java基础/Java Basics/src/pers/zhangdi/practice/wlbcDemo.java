package pers.zhangdi.practice;

//服务器端：主要使用ServerSocket

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

//网络程序的开发的两个核心的类：服务器类：ServerSocket 	客户端类：Socket
public class wlbcDemo {
	public static void main(String[] args)throws Exception {
		ServerSocket server = new ServerSocket(9000) ;		//所有的服务器都必须有端口
		System.out.println("等待客户连接。。。。");
		Socket client = server.accept() ; 	//等待客户端连接
		
//		OutputStream out = client.getOutputStream() ;		//取得客户端的输出功能
//		byte b[] = new byte[100] ;
//		String str = "Hello , word!" ;
//		b = str.getBytes() ;
//		out.write(b);
//		out.close();
		
		//由于输出流不方便，采用打印流
		PrintStream out=new PrintStream(client.getOutputStream());		//取得客户端的输出功能
		out.print("Hello,word!");
		out.close();
		
		client.close();
		server.close();
	}
}
