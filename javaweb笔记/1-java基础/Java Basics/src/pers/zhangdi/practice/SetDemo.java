package pers.zhangdi.practice;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//Set接口的子类:HashSet（无序排列） 、 TreeSet（自动排序）			(Set不能保存重复的数据)
public class SetDemo {
	public static void main(String[] args) {
		//HashSet类（无序排列）
		Set<String> set = new HashSet<String>() ;
		set.add("Hello1") ;
		set.add("Hello2") ;
		set.add("Word!") ;
		set.add("Hello3") ;
		set.add("Hello4") ;
		set.add("Hello5") ;
		System.out.println("集合长度： " + set.size() + "\t是否为空 ：" + set.isEmpty() + "\t内容： " + set);
		
		//TreeSet类（自动排序，按照某种规律）
		Set<String> set1 = new TreeSet<String>() ;
		set1.add("Hello1") ;
		set1.add("Hello2") ;
		set1.add("Word!") ;
		set1.add("Bello3") ;
		set1.add("Hello4") ;
		set1.add("Hello1") ;
		System.out.println("集合长度： " + set1.size() + "\t是否为空 ：" + set1.isEmpty() + "\t内容： " + set1);
		
	}
}
