package pers.zhangdi.practice;

//代理设计模式（通过代理对象间接操控原对象），
//代理对象可以在客户端和目标对象之间起到中介的作用。
//例子：现实中通过代理访问 网络

interface Network{			//定义Network接口
	public void SurfTheInternet() ;			//定义上网的抽象方法
}
class Subject implements Network{			//定义真实主题，真正的上网操作
	public void SurfTheInternet() {			
		System.out.println("真实对象正在上网");
	}
}

class ProxySubject implements Network{		//定义代理主题
	private Network network ;
	public ProxySubject(Network network) {			//设置代理的操作（将真实主题传入进来）
		this.network = network ;
	}
	
	public void Check() {
		System.out.println("检查用户是否合法");
	}

	public void SurfTheInternet() {
		this.Check();
		this.network.SurfTheInternet();
	}
}

public class ProxyDemo {
	public static void main(String[] args) {
		Network net = new ProxySubject(new Subject()) ;		//声明并实例化代理，同时传入代理的操作
		net.SurfTheInternet();			//调用代理的上网操作（代码运行结果其实是真实主题的上网操作）
	}
}