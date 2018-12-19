package pers.zhangdi.practice;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//HashMap和Hashtable	：Hashtable中对于Key和value的数据都不能数值为null,而HashMap可以
//Key尽量使用String
public class HashMapDemo {
	public static void main(String[] args) {
		//HashMap的使用
		//HashMap定义的Map集合是无序存放的，若Key重复，会进行覆盖，新的内容替代就得内容
		Map<String , Integer> map = new HashMap<String , Integer>() ;
		map.put("one", 1) ;
		map.put("two", 2) ;
		map.put("five", 5) ;
		map.put("five", 33) ;
		map.put("three", 3) ;
		map.put("four", 4) ;
		map.put("four1", 4) ;
		map.put(null, null) ;
		System.out.println(map);
		System.out.println(map.get("five"));
		System.out.println(map.get(null));
		//通过以上的代码可以发现，Map存放数据的最终目的实际上就是为了信息的查找，但是Collection存放数据的目的是为了输出。
		//获取全部的Key(将Key保存在Set集合中)
		Set<String> set = map.keySet() ;
		Iterator<String> it = set.iterator() ;
		while(it.hasNext()) {
			System.out.print(it.next() + "\t");
		}System.out.println();
		
		//Hashtable
		Map<String , Integer> map1 = new Hashtable<String , Integer>() ;
		map1.put("一", 1) ;
		map1.put("三", 3) ;
		map1.put("四", 4) ;
		map1.put("二", 2) ;
		map1.put("五", 5) ;
		System.out.println(map1);
		
		//利用Iterator实现Map接口的输出：将Map集合变为Set集合，目的是为了使用iterator()方法
		Set<Map.Entry<String, Integer>> set1 = map.entrySet() ;		//利用Map接口的entrySet()方法将Map集合变为Set集合，里面的泛型是Map.Entry
		Iterator<Map.Entry<String, Integer>> it1 = set1.iterator() ;	//利用Set集合中的iterator()方法将Set集合进行Iterator输出；
		while(it1.hasNext()) {
			Map.Entry<String, Integer> me = it1.next() ;		//每一次Iterator循环取出的都是Map.Entry接口对象，利用此对象进行key与value的取出
			System.out.println(me.getKey() + " = " + me.getValue());
		}
	}
}
