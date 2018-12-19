package pers.zhangdi.practice;
//经过异常类的观察可以发现所有的异常类都是Throwable的子类
//（面试题：请解释Error和Exception的 区别） 
//Error：指的是JVM错误，即此时的程序还没有执行，如果没有执行用户无法处理。
//Exception：指的是程序运行中产生的异常，用户可以处理。也就是所谓的异常处理指的就是所有Exception以及它的子类异常。 

//面试题：throw和throws的区别？
//throw：指的是在方法之中人为抛出一个异常类对象（这个异常类对象可能是自己实例化或者是抛出已存在的）；
//throws：指的是在方法的声明上使用，表示此方法在调用时必须处理异常
public class Demo3 {
	public static void main(String args[]) {
		System.out.println("1�����㿪ʼ");
		try {
			System.out.println("2���������㣨10/0��" + (10/0));
		}
		catch(Exception e){
			System.out.println("++++++++++�����쳣��+++++++++++");
			System.out.println("��ӡ�쳣��");
			e.printStackTrace();
		}
		finally{
			System.out.println("���ܳ�û�����쳣�Ҷ���ִ�У�finally��");
		}
		System.out.println("3�������������");
	}
}
