package pers.zhangdi.practice;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

//Runnable接口里面的run()方法不能返回操作结 果。为了解决这样的矛盾，提供了一个新的接口Callable接口。
//Callable接口中的call()方法执行完线程的主体功能之后可以返回一个结果，而返回结果的类型由Callable接口上的泛型来决定。
public class ThreadDemo1 {
	public static void main(String[] args)throws Exception {
		MyThread2 mt1 = new MyThread2() ;
		MyThread2 mt2 = new MyThread2() ;
		FutureTask<String> task1 = new FutureTask<String>(mt1) ;	//目的是为了取得call()的返回结果
		FutureTask<String> task2 = new FutureTask<String>(mt2) ;
		new Thread(task1).start();			//启动多线程
		new Thread(task2).start();
		//多线程执行完毕后可以取得内容，依靠FutureTask的父接口Future中的get()方法
		System.out.println("A线程的返回结果: " + task1.get());
		System.out.println("B线程的返回结果: " + task2.get());
	}
}

class MyThread2 implements Callable<String>{
	private String name ;
	private int ticket = 10 ;
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 100 ; i++) {
			if(this.ticket > 0) {
				System.out.println("卖票：ticket——>" + this.ticket--);
			}
		}
		return "票卖光了";
	}
	
}