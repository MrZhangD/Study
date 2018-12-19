package pers.zhangdi.practice;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	public static void main(String[] args)throws Exception {
		ServerSocket server = new ServerSocket(9111) ;
		Socket client = server.accept() ; 	//等待客户端连接
		//得到客户端输入数据以及向客户端输出数据的对象
		Scanner scan = new Scanner(client.getInputStream()) ;		//得到客户端的输入数据
		PrintStream out = new PrintStream(client.getOutputStream()) ;		//向客户端输出数据

		boolean flag = true ;
		while(flag) {
			if(scan.hasNext()) {
				String str = scan.next().trim() ;	//得到客户端的输入的内容，并去除空格
				if(str.equalsIgnoreCase("byebye")) {	//程序要结束：equalsIgnoreCase()是忽略大小写的比较
					out.println("拜拜，程序结束！");
					flag = false ;
				}else {		//回应信息
					out.println("（服务器端）ECHO: " + str);
				}
			}
		}
		
		scan.close();
		out.close();
		client.close();
		server.close();
	}
}
