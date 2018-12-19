package pers.zhangdi.practice;

//由此可得出：每当使用java命令去解释一个程序类的时候，对于操作系统而言，
//都相当于启动了一个新的进程，而main只是这新进程上中 的一个子线程而已。
//提问：每一个JVM进程启动的时候至少启动几个线程？
//(1)、main线程：程序的主要执行，以及启动子线程；
//(2)、gc线程：负责垃圾收集。


public class ThreadDemo2 {
	public static void main(String[] args) throws Exception {
		MyThread3 mt = new MyThread3() ;
		Thread th1 = new Thread(mt , "线程A") ;
		Thread th2 = new Thread(mt , "线程B") ;
		Thread th3 = new Thread(mt , "线程C") ;
//		th1.start();
//		th1.sleep(100);
//		th2.start();
//		th2.sleep(100);
//		th3.start();
//		th3.sleep(100);
//		mt.run();		//线程一直存在，主方法就是主线程
		
		//线程的优先级
//		发现设置和取得 优先级都是使用了int属于类型，对于此内容有三种取值：  
//		最高优先级：public static final int MAX_PRIORITY;//10 
//		中等优先级：public static final int NORM_PRIORITY;//5 
//		最低优先级：public static final int MIN_PRIORITY;//1 
		th1.setPriority(5);
		th2.setPriority(10);
		th3.setPriority(2);
		th1.start();
		th2.start();
		th3.start();
		System.out.println(Thread.currentThread().getName() + " 优先级：" + Thread.currentThread().getPriority());		
	}
}

class MyThread3 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		如下行语句，若在休眠的时候如果设置了多个线程对象，那么所有的线程对象将一起进入到run()方法（所谓的一起进入实际上是因为先后顺 序实在是太短了，但实际上有区别。
//		Thread.currentThread().sleep(1000);
		System.out.println(Thread.currentThread().getName());		//取得当前线程对象的名字
	}
	
}