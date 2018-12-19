package pers.zhangdi.practice;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

//字符流：Writer:输出流		Reader：输入流
public class zfIODemo {
	public static void main(String[] args)throws Exception {
		File file = new File("D:" + File.separator + "1" + File.separator + "2" + File.separator + "3" + File.separator , "demo3.txt") ;
		String str = "好好学习，天天向上！ " ;
		write(str , file) ;
		String str1 = read(file) ;
		System.out.println(str1);
	}
	
	//输出流（写入）
	public static void write(String str , File file) throws Exception {
		if(!file.getParentFile().exists())
			file.getParentFile().mkdirs() ;
		Writer write = new FileWriter(file , true) ;	//加true属性使内容追加而不是覆盖
		write.write(str);
		write.close();
	}
	
	//输入流（读取）
	public static String read(File file)throws Exception {
		if(!file.getParentFile().exists())
			return null ;
		else {
			Reader read = new FileReader(file) ;
			char ch[] = new char[100] ;
			read.read(ch) ;
			String str = new String(ch) ;
			read.close();
			return str ;
		}
	}
}
