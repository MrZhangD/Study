package pers.zhangdi.practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//java反射机制


public class javaReflectionDemo {
	public static void main(String[] args) throws Exception {
//		Date date = new Date() ;
//		Class<?> cls = date.getClass() ;
//		Class<?> cls1 = Date.class ;
//		Class<?> cls2 = Class.forName("java.util.Date") ;
//		System.out.println(cls);
//		System.out.println(cls1);
//		System.out.println(cls2);
	
//		//利用反射实现对象的实例化
//		Class<?> cls = Class.forName("pers.zhangdi.practice.Book") ;	//通过类名获得类的信息 ，一种反射机制，只需知道类名就能获得类的信息
//		Object obj = cls.newInstance() ;		// newInstance 类似于 new  都是实例化对象，但前者只能调用无参构造方法
//		Book book = (Book) obj ;		//向下转型
//		System.out.println(obj);
//		System.out.println(book);
//		
//		//若当前类中没有无参构造，使用newInstance的话会造成程序无法进行对象的实例化，
//		//在Class中有一个方法能够取得构造，这样解决上述问题
//		//取得全部构造：public T newInstance()throws InstantiationException,IllegalAccessException
//		//取得一个指定参数顺序的构造：public Constructor<T> getConstructor(Class<?>... parameterTypes)throws NoSuchMethodException,SecurityException
//		Class <?> cls = Class.forName("pers.zhangdi.practice.Book") ;
//		Constructor<?> con = cls.getConstructor(String.class) ;
//		Object obj = con.newInstance("java开发") ;
//		System.out.println(obj);
		
		//使用反射调用普通方法
		//取得一个类中的全部方法：public Method[] getMethods()throws SecurityException 
		//取得指定方法：public Method getMethod(String name, Class<?>... parameterTypes)throws NoSuchMethodException,SecurityException 	第一个参数是获得方法的名字，第二个参数是按声明顺序标识方法的形参类型
		//调用方法：public Object invoke(Object obj, Object... args)throws IllegalAccessException,IllegalArgumentException,InvocationTargetException 
		String name = "name" ;
		Class<?> cls = Class.forName("pers.zhangdi.practice.Book1") ;
		Object obj = cls.newInstance() ;		//必须给出实例化对象
		Method setmet = cls.getMethod("set" + initcap(name), String.class) ;	//第一个形参是方法的名字，第二个形参是参数的类型
		Method getmet = cls.getMethod("get" + initcap(name)) ;		//无参方法
		setmet.invoke(obj , "java开发") ;		//调用方法
		System.out.println(getmet.invoke(obj));
	}
	
	public static String initcap(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1) ;
	}
}


class Book{
	public Book() {
		System.out.println("---------------Book的无参构造---------------");
	}
	public Book(String name) {
		System.out.println("++++++++++++Book的有参构造+++++++++++++++" + name);
	}
	public String toString() {
		return "这是一本书" ;
	}
}

class Book1{
	private String name ;
	public void setName(String name) {
		this.name = name ;
	}
	public String getName() {
		return this.name ;
	}
}