package pers.zhangdi.practice;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
//集合输出
public class jhscDemo {
	public static void main(String[] args) {
		//使用Iterator输出集合，Iterator接口如果想要取得本接口实例化只能依靠Collection接口，在Collection接口中定义了取得Iterator对象的操作方法，既然Collection有这个方法List和Set全有了。
		List<String> list = new ArrayList<String>() ;
		list.add("Hello , ") ;
		list.add("Word ! ") ;
		list.add("你好 , ") ;
		list.add("世界 ！") ;
		Iterator<String> it = list.iterator() ;
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//使用Enumeration输出集合，要取得Enumeration接口的实例化对象要依靠 Vector子类,在Vector子类中定义了取得Enumeration对象的操作方法
		Vector<String> list1 = new Vector<String>() ;
		list1.add("Hi , ") ;
		list1.add("tomorrow ！ ") ;
		list1.add("你好 , ") ;
		list1.add("明天 ！ ") ;
		Enumeration<String> enu = list1.elements() ;
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
	}
}