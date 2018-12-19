package pers.zhangdi.practice;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args)throws Exception {
		Socket client = new Socket("localhost" , 9111) ;
		Scanner input = new Scanner(System.in) ;		//键盘输入数据
		Scanner scan = new Scanner(client.getInputStream()) ;		//获得客户端输入的数据
		input.useDelimiter("\n") ;
		scan.useDelimiter("\n") ;
		PrintStream out = new PrintStream(client.getOutputStream()) ;	
		boolean flag = true ;
		while(flag) {
			System.out.println("（客户端）请输入要传输的数据：");
			if(input.hasNext()) {
				String str =input.next().trim() ;
				out.println("客户端2：" + str);		//发送服务器端数据
				if(str.equalsIgnoreCase("byebye")) {
					flag = false ;		//结束循环
				}
				if(scan.hasNext()) {
					System.out.println(scan.next() + "客户端3");	//输出回应数据
				}
			}
		}
		input.close();
		scan.close();
		out.close();
		client.close();
	}
}
