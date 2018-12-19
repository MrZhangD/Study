package pers.zhangdi.practice;
//字节流：OutputStream ， InputStream
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class zjIODemo {
	public static void main(String[] args) throws Exception{
		//1、定义要输出文件的路径
		File file = new File("D:" + File.separator + "1" + File.separator + "2" + File.separator + "3" +  File.separator , "demo2s.txt") ;
		//输出流（写入）
		String str = "hello , word!" ;
		output(str , file) ;
		//输入流（读取）
		String str1 = input(file) ;
		System.out.println(str1);
	}
	
	public static void output(String str , File file) throws Exception {
		//1、若目录不存在则创建它
		if(!file.getParentFile().exists())
			file.getParentFile().mkdirs() ;
		//2、定义输出流
		OutputStream output = new FileOutputStream(file,true) ;//加上true属性将会进行追加输出，不会覆盖之前的内容
		//3、输出内容(文件不存在会自动创建)
		byte b[] = str.getBytes() ;
		output.write(b);
		//4、关闭输出流资源
		output.close();
	}
	
	public static String input(File file) throws Exception {
		if(!file.getParentFile().exists())
			return null ;
		else {
			@SuppressWarnings("resource")
			InputStream input = new FileInputStream(file) ;
			byte b[] = new byte[100] ;
			input.read(b) ;
			String str = new String(b) ;
			return str ;
		}
	}
}	
