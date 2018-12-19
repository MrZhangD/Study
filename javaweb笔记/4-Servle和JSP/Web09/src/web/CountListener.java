package web;
//在线人数监听器
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{

	@Override
	//session创建时会调用这个方法
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		//先获取一个session，从此获取servelet上下文
		System.out.println("session创建了。。。");
		ServletContext context = arg0.getSession().getServletContext();
		Integer count = (Integer) context.getAttribute("count");
		if(count == null){
			count = 1 ;
		}else{
			count ++ ;
		}
		//将count绑定到servlet上下文中
		context.setAttribute("count", count);
	}

	@Override
	//session销毁时会调用此方法
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("session销毁了。。。");
		ServletContext context = arg0.getSession().getServletContext();
		Integer count= (Integer) context.getAttribute("count");
		count -- ;
		context.setAttribute("count", count);
	}
	
}
