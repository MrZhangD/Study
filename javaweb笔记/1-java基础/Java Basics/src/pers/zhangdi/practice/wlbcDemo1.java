package pers.zhangdi.practice;

//定义客户端：主要使用Scoket

import java.net.Socket;
import java.util.Scanner;

public class wlbcDemo1 {
	public static void main(String[] args)throws Exception {
		Socket client = new Socket("localhost" , 9000) ;	//连接服务器
		//取得客户端的输入数据流对象，表示接受服务器端的输出信息
		Scanner scan = new Scanner(client.getInputStream()) ;	
		scan.useDelimiter("\n") ;
		if(scan.hasNext()) {
			System.out.println("回应数据： " + scan.next());
		}
		
		scan.close();
		client.close();
	}
}	
