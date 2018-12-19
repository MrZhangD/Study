package pers.zhangdi.practice;

import java.io.File;
import java.io.IOException;

public class FielDemo {
	public static void main(String[] args) throws IOException {
//		boolean flag = false ;
//		File file = new File("D:" + File.separator + "1" + File.separator + "2" + File.separator + "3" +  File.separator , "demo2.txt") ;
//		if(!file.getParentFile().exists()) {
//			file.getParentFile().mkdirs() ;
//		}
//		if(file.exists()) {
//			file.delete();
//		}else
//			flag = file.createNewFile() ;
//		System.out.println("是否是文件： " + file.isFile());
//		System.out.println("是否是目录： " + file.isDirectory());
//		System.out.println("文件的长度： " + file.length());
//		System.out.println("最近修改时间： " + file.lastModified());
//		System.out.println(file.getParent());	//展示文件的父目录
//		System.out.println(flag);
		
		//列出目录中的内容
//		File file = new File("D:" + File.separator) ;
//		if(file.isDirectory()) {
//			File result[] = file.listFiles() ;
//			System.out.println("文件数目：" + result.length);
//			for(int i = 0 ; i < result.length ; i++) {
//				 System.out.println(result[i].getName() + "\t\t\t" + 
//						 new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(result[i].lastModified())) + "\t\t" + 
//						 (result[i].isDirectory()?"文件夹":"文件") + "\t\t" + 
//						 (result[i].isFile()?(new BigDecimal((double)file.length()/1024/1024).divide(new BigDecimal(1),2,BigDecimal.ROUND_HALF_UP)):""));
//			}
//		}
		
//		//递归列出指定路径下的所有文件
//		File file = new File("D:" + File.separator + "编程安装文件") ;
//		print(file) ;
		
//		//删除
//		File file = new File("D:" + File.separator + "1" + File.separator + "2" + File.separator + "3" +  File.separator , "demo2.txt") ;
//		if(file.exists()) {
//			System.out.println("文件是否删除： " + file.delete());
//		}
//		System.out.println("文件是否存在：" + file.exists());
	}
	
	public static void print(File file) {
		File f[] = file.listFiles();
		for(int i = 0 ; i < f.length ; i++) {
			if(f[i].isDirectory())
				print(f[i]);
			if(f[i].isFile())
				System.out.println(f[i]);
		}
	}
}