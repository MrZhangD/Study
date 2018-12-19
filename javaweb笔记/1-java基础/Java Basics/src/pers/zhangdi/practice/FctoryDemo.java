package pers.zhangdi.practice;

//工厂设计模式（主要是为创建对象提供过渡接口，以便将创建对象的具体过程屏蔽隔离起来，达到提高灵活性的目的。）
//但是如果用工厂模式，你只需要修改工厂代码。其他地方引用工厂，可以做到只修改一个地方，其他代码都不动，就是解耦了。

//如果增加Fruit接口子类，那就要修改工厂类，例：若添加一个子类水果西瓜，那Factory类中就要修改
//产生以上问题的原因是工厂类中的所有对象都是通过new关键字直接实例化的，要想解决此类问题，就要依靠反射来完成
//此时的程序就完成了解耦合的目的。而且可扩展性非常的强

interface Fruit{
	public void eat() ;
}

class Apple implements Fruit {

	@Override
	public void eat() {
		System.out.println("吃苹果");
	}
}

class Orange implements Fruit {

	@Override
	public void eat() {
		System.out.println("吃橘子");
	}
}

class Watermelon implements Fruit {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("吃西瓜");
	}
}

class Factory{					//工厂类
	public static Fruit getInstance(String name) throws Exception {
		Class<?> cls = Class.forName("pers.zhangdi.practice." + name) ;			//通过类名获得类的信息 ，一种反射机制，只需知道类名就能获得类的信息
		Object obj = cls.newInstance() ;		//newInstance 类似与 new
//		Fruit fruit = (Fruit) obj ;
//		return fruit ;		
		return (Fruit)obj ;		//向下转型
	}
}

public class FctoryDemo  {
	public static void main(String[] args)throws Exception {
		Fruit fruit = Factory.getInstance("Apple") ;
		fruit.eat();
	}
}
