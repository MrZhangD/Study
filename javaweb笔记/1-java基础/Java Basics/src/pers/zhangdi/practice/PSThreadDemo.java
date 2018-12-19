package pers.zhangdi.practice;
//知识点：（1）消费者生产者问题	（2）Object类对多线程的支持
//面试题：请解释sleep()与wait()的区别？
//sleep()是Thread类定义的方法，wait()是Object类定义的方法； 
//sleep()可以设置休眠时间，时间一到自动唤醒，而wait()需要等待notify()进行唤醒。
//http://ifeve.com/producers-and-consumers-mode/
public class PSThreadDemo {
	public static void main(String[] args) {
		Info info = new Info() ;
		new Thread(new Productor(info) , "生产者").start();
		new Thread(new Customer(info) , "消费者").start();
	}
}

class Info{
	private String type ;
	private String name ;
	private boolean flag = true;		//flag默认值为false，所以一开始不能生产，取的时候为null。要设为true，才能一开始就能 生产产品 
	//flag = true ; 表示可以生产，但不可以取走 
	//flag = false ; 表示可以取走，但不可以生产
	public synchronized void set (String type , String name) {		//生产
		//同步方法：重复进入到了set()方法里，发现不能生产，所以要等待
		if(this.flag == false) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//++++++++++++++++++++++++++++++++++++++++++++
		this.type = type ;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name = name ;
		this.flag = false ;		//修改生产标记
		super.notify();			//唤醒其他等待进程
	}
	
//+===========================================================================================
	public synchronized void get() {		//取货
		if(this.flag == true) {
			//此时还没生产呢	发现不能取货，所以需要等待
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//+++++++++++++++++++++++++++++++++++++++++++		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.type + "---" + this.name);
		this.flag = true ;
		super.notify();
	}		
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

//生产者线程类
class Productor implements Runnable{
	private Info info ;
	Productor(Info info){
		this.info = info ;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i <= 20 ; i++) {
			if(i%2==0) {	//偶数生产牙刷
				this.info.set("生活用品类", "牙刷");
			}else {
				this.info.set("食品类", "牛奶");
			}
		}
	}
}

//消费者线程类
class Customer implements Runnable{
	private Info info ;
	Customer(Info info){
		this.info = info ;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i <= 20 ; i++) {
			this.info.get();
		}
	}
}

