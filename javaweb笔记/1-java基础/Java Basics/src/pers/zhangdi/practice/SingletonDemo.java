package pers.zhangdi.practice;
//单例设计模式（饿汉式）其核心目的是，让一个类在整个系统里只允许存在有一个实例化对象。
//1、单例类只能有一个实例。
//2、单例类必须自己创建自己的唯一实例。
//3、单例类必须给所有其他对象提供这一实例。

class Singleton{
	private static final Singleton INSTANCE = new Singleton() ; 
	private Singleton() {} //构造方法私有化
	public static Singleton getInstance() {
		return INSTANCE ;	
	}
	public void print() {
		System.out.println("hello,word!");
	}
}
//构造方法私有化，在类的内部定义static属性与方法，利用static方法取得本类的实例化对象,
//不管外部会产生多少个 Singleton类的对象，但是本质上永远只有唯一的一个实例化对象。
public class SingletonDemo {
	public static void main(String[] args) {
		 Singleton s=Singleton.getInstance(); 
		 Singleton s1=Singleton.getInstance(); 
		 Singleton s2=Singleton.getInstance(); 
		 s.print();
		 s1.print();
		 s2.print();
	}
}
