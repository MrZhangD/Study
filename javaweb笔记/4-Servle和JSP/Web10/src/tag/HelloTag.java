package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
	/* 
	 * 标签类
	 * 1、继承SimpleTagSupport类
	 * 2、override doTag方法
	 * 3、标签有哪些属性，标签类也要有对应的属性
	 * 	a.属性名称一致
	 * 	b.类型要匹配
	 * 	c.要有相应的setter方法
	 * 
	 * SimpleTagSupport类里提供了一个方法来获得pageContext-->PageContext pc = (PageContext)getJspContext(); 
	 * pageContext提供了一些方法来获得所有的隐含对象-->JspWriter out = pc.getOut();
	 */
	private String msg ;
	private Integer num ;
	public HelloTag(){
		System.out.println("HelloTag的构造器。。。");
	}
	public void setMsg(String msg) {
		System.out.println("setMsg()...." + msg);
		this.msg = msg;
	}
	public void setNum(Integer num) {
		System.out.println("setNum()...." + num);
		this.num = num;
	}
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext)getJspContext(); 
		JspWriter out = pc.getOut();
		for(int i = 0 ; i < num ; i++){
			out.println(msg + "<br>");
		}
	}
}
