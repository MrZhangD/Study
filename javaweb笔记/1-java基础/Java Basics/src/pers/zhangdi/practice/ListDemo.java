package pers.zhangdi.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//List接口的子类：ArrayList、Vector			(顺序是怎么放就怎么排)
public class ListDemo {
	public static void main(String[] args) {
		//设置了泛型，保证集合中所有数据的类型都是一致的
		List<String> list = new ArrayList<String>() ;
		System.out.println(list.size() + "\t集合是否为空：" + list.isEmpty());
		list.add("Hello") ;
		list.add("Hello") ;		//List接口的子类可以有重复的数据
		list.add("word!") ;
		System.out.println(list.size() + "\t集合是否为空：" + list.isEmpty());
		//取得数据
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
		//集合里保存对象
//		List<Boook> listb = new ArrayList<Boook>() ;
//		listb.add(new Boook("java开发" , 90.9))  ;
//		listb.add(new Boook("javaweb开发" , 12.9))  ;
//		listb.add(new Boook("mysql学习" , 112.9))  ;
//		for(int i = 0 ; i < listb.size() ; i++) {
//			System.out.println(listb.get(i));
//		}
//		listb.remove(1) ;
//		System.out.println(listb);
		
//		//Vector类(也是实现List接口的)
//		List<String> list1 = new Vector<String>() ;
//		list1.add("Hello") ;
//		list1.add("Hello") ;
//		list1.add("Word!") ;
//		System.out.println("集合的长度： "+ list1.size() + "\t" + list1 + list1.get(2));
	}
}

class Boook {
	private String name ;
	private double price ;
	Boook(String name , double d){
		this.name = name ;
		this.price = d ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Boook [name=" + name + ", price=" + price + "]";
	}
	
}