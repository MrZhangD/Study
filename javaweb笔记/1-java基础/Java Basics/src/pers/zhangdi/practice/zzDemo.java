package pers.zhangdi.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//正则表达式
public class zzDemo {
	public static void main(String[] args)throws Exception {
//		//实现字符串的替换
//		String str = "1张2迪a张b迪A张B迪123aBc456AbC" ;
//		String regex = "[a-zA-Z0-9]" ; 	//此处编写正则
//		System.out.println(str.replaceAll(regex, ""));		//将匹配regex的字符替换为""
//		
//		//字符串拆分（按照数字拆分）
//		String regex1 = "[\\d+]" ;		//表示数字出现一次或一次以上的正则
//		String result[] = str.split(regex1) ;
//		for(int i = 0 ; i < result.length ; i++) {
//			System.out.println("++++" + result[i] + "++++");
//		}
//		
//		//验证一个字符串是不是数字，如果是则将其变成double型
//		String str1 = "20" ;
//		String regex2 = "\\d+(\\.\\d+)?" ;			//数字可能是整数也可能是小数
//		System.out.println(str1.matches(regex2));
//		if(str1.matches(regex2))
//			System.out.println(Double.parseDouble(str1));
//		
//		//判定给定的字符串是否是IP地址
//		String str2 = "192.168.212.221" ;
//		String regex3 = "\\d{1,3}(\\.\\d{1,3}){3}" ;	//	\\d出现1到3次，（\\.和出现一到三次的\\d）一共出现3次
//		System.out.println(str2 + " 是否是IP地址：" + str2.matches(regex3));
//		
		//判定给定的字符串判定是否是 yyyy-MM-dd的格式	如果是则将其转换成Date型数据！
//		String str3 = "2018-01-22" ;	
//		String regex4 = "\\d{1,4}(\\-\\d{2}){2}" ;
//		System.out.println(str3 + "  是否是yyyy-MM-dd的格式 ： " + str3.matches(regex4));
//		if(str3.matches(regex4)) {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
//			Date date = sdf.parse(str3) ;
//			Date date1 = new Date(System.currentTimeMillis()) ;
//			System.out.println(date + " 格式化后为： " + sdf.format(date));
//			System.out.println("目前系统时间为：" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date1));
//		}
//		
		//验证是否是email地址
		String str4 = "zhang_di102@qq.com" ;
		String regex5 = "[a-zA-Z0-9][a-zA-Z0-9_\\.]{0,28}[a-zA-Z0-9]@\\w+\\.(com|cn|net|com\\.cn|net\\.cn|edu|gov|org)" ;
		System.out.println(str4 + "是否是email地址： " + str4.matches(regex5));
		
//		//利用Pattern和Matcher类
//		String str5 = "12ad4as1dvA3D22sdaS" ;
//		String regex6 = "[a-zA-Z0-9]+" ;
//		Pattern pattern = Pattern.compile(regex6) ;		//编译正则
//		Matcher mat = pattern.matcher(str5) ;
//		System.out.println(mat.matches());	//匹配结果	与str5.matches(regex6)	一样
		
	}
}
