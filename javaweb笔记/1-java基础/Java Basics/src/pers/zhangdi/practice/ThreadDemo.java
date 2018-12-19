package pers.zhangdi.practice;
//多线程		多线程应该是多个线程彼此交替执行
//，多线程启动的唯一方法就是Thread类中的start()方法
//Thread类可以实现多线程，但是具有单继承局限，为了解决此问题，java中提供了Runnable接口
//使用Runnable接口，可以比Thread类能够更好的描述出数据共享这一概念。


public class ThreadDemo {
	public static void main(String[] args) {
		//这属于顺序执行，并没有交替执行线程
//		Thread thread1 = new MyThread("线程1 ") ;
//		Thread thread2 = new MyThread("线程2 ") ;
//		Thread thread3 = new MyThread("线程3 ") ;
//		thread1.start();
//		thread2.start();
//		thread3.start();
		
//		//实现了Runnable接口的类	实现的是Runnable接口，并没有start()方法可以被继承。 
//		//要想启动多线程一定要依靠Thread类完成，在Thread类里面定义有以下的构造方法：    public Thread(Runnable target),接收的是Runnable接口对象； 
//		MyThread mt1 = new MyThread("线程1 ") ;
//		MyThread mt2 = new MyThread("线程2 ") ;
//		MyThread mt3 = new MyThread("线程3 ") ;
//		new Thread(mt1).start();		//使用Threa类中的start()方法启动线程
//		new Thread(mt2).start();
//		new Thread(mt3).start();
		
//		//以下两个是说明实现接口Runnable的多线程比继承Thread类的多线程更能体现数据共享
//		Thread thread1 = new MyThread1() ;
//		Thread thread2 = new MyThread1() ;
//		Thread thread3 = new MyThread1() ;
//		thread1.start();
//		thread2.start();
//		thread3.start();
		
		//此时也属于三个线程对象，可是唯一的区别是：这三个线程对象都直接占用了同一个MyThread类的对象引用，也就是说着三个线程对象 都直接访问同一个数据资源。 
		MyThread1 mt = new MyThread1() ;
		new Thread(mt , "aa").start();
		new Thread(mt , "bb").start();
		new Thread(mt , "cc").start();
	}
}

class MyThread implements Runnable{		//这是一个多线程的操作类
	private String name ;
	public MyThread(String name) {
		this.name = name ;
	}
	public void run() {			//覆写run()
		for(int i = 0 ; i < 50 ; i++) {
			System.out.println(this.name + " -> " + i);
		}
	}
}

class MyThread1 implements Runnable{
	private String name ;
	private int ticket = 10 ;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0 ; i < 200 ; i++) {
			if(this.ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "卖票：ticket->" + this.ticket--);
			}
		}
	}
	
}