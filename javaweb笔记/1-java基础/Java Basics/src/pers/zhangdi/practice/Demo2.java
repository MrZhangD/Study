package pers.zhangdi.practice;

//继承是一个 "是不是"的关系，而 接口 实现则是 "有没有"的关系。
//如果一个类继承了某个抽象类，则子类必定是抽象类的种类，而接口实现则是有没有、具备不具备的关系，
//比如鸟是否能飞（或者是否具备飞行这个特点），能飞行则可以实现这个接口，不能飞行就不实现这个接口。
//接口中只能有抽象方法和全局变量

interface USB{
	public void start() ;
	public void stop();
}

class Computer{
	public void plugin(USB usb) {
		usb.start();
		usb.stop();
	}
}

class Flash implements USB {

	@Override
	public void start() {
		System.out.println("U�̿�ʼʹ��");
	}

	@Override
	public void stop() {
		System.out.println("U��ֹͣʹ��");
	}
	
	public String toString () {
		return "Flash" ;
	}
	
	public void getInfo() {
		System.out.println("flash");
	}
} 

class Print implements USB{

	@Override
	public void start() {
		System.out.println("��ӡ����ʼʹ��");
	}

	@Override
	public void stop() {
		System.out.println("��ӡ��ֹͣʹ��");
	}
	
}

public class Demo2 {
	public static void main(String[] args) {
		Computer com = new Computer() ;
		com.plugin(new Flash());
		com.plugin(new Print());
		new Flash().getInfo(); ;
		System.out.println(new Flash().toString());
	}
}
