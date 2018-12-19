package pers.zhangdi.practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//缓冲流和转换流
public class hcIODemo {
	public static void main(String[] args)throws Exception {
//		//缓冲字节输出流
//		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("D:\\1\\2\\3\\demo3.txt" , true)) ;
//		String str = "你好" ;
//		byte b[] = str.getBytes() ;
//		out.write(b);
//		out.flush();	//刷新内存，将内存中的数据立刻写出。close()中自带flush().可以不用
//		out.close();
//		
//		//缓冲字节输入流
//		BufferedInputStream in = new BufferedInputStream(new FileInputStream("D:\\1\\2\\3\\demo3.txt")) ;
//		byte b1[] = new byte[1024] ;
//		in.read(b1) ;
//		String str1 = new String(b1) ;
//		System.out.println(str1);
//		in.close() ;

//		//缓冲字符输出流
//		BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\1\\2\\3\\demo3.txt" , true)) ;
//		bw.write("s世界！");
//		bw.flush();		//刷新内存，将内存中的数据立刻写出。close()中自带flush().可以不用
//		bw.close();
//
//		//缓冲字符输入流
//		BufferedReader read = new BufferedReader(new FileReader("D:\\1\\2\\3\\demo3.txt"));
//		String str ;
//		while((str = read.readLine()) != null)
//			System.out.println(str);
//		read.close() ;

		
		//转换流	OutputStreamWriter：字符流转换成字节流		InputStreamReader：字节流转换成字符流
		//1、字符流——>字节流 	OutputStreamWriter 写入
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\1\\2\\3\\demo3.txt" , true))) ;
		String str = "寒假寒假1!" ;
		bw.write(str);
		bw.close();
		
		//2、字节流——>字符流	InputStreamReader 读取  
		File file = new File("D:\\1\\2\\3\\demo3.txt") ;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
		String str1 ;
		while((str1 = br.readLine()) != null)
			System.out.println(str1);
		br.close();
	}
}
