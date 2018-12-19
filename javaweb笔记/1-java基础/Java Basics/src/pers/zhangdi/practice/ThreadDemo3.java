package pers.zhangdi.practice;
//进程的同步与死锁
//同步：使用synchronized	通过两种方式使用：（1）同步代码块:：synchronized(锁定对象){代码}；（2）同步方法：public synchronized 返回值 方法名称(){代码}
//扩展知识：java中一共有四种代码块：1、构造块		2、普通代码块		3、静态块		4、同步块
//同步操作与异步操作相比，异步操作的执行速度要高于同步操作，但是同步操作时数据的安全性较高，属于安全的线程操作。
//死锁：所谓的同步指的就是一个线程对象等待另外一个线程对象执行完毕后的操作形式。线程同步过多就有可能造成 死锁。
public class ThreadDemo3 {
	public static void main(String[] args) {
		MyThread4 mt = new MyThread4() ;
		new Thread(mt , "售票员A").start() ;
		new Thread(mt , "售票员B").start() ;
		new Thread(mt , "售票员C").start() ;
	}
}

class MyThread4 implements Runnable{
	private int ticket = 10 ;
//	@Override
	//使用同步块实现进程的同步
//	public void run() {
//		// TODO Auto-generated method stub
//		for(int i = 0 ; i < 50 ; i++) {
//			synchronized(this) {			//同步块实现进程的同步：当前操作每次只允许一个对象进入
//				if(ticket>0) {
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println(Thread.currentThread().getName() + "-卖票：-》" + ticket--);
//				}
//			}
//		}
//	}

	@Override
	//使用同步方法实现进程的同步
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 50 ; i++) {
			this.sale();			//调用同步方法
		}
	}
	
	public synchronized void sale() {		//同步方法
		if(ticket > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-卖票：-》 " + ticket--);
		}
	}
}
