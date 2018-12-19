package web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IEmpService;
import sqlConn.DatabaseConnect;
import vo.Emp;
import dao.IEmpDao;
import factory.DaoFactory;
import factory.ServiceFactory;

public class AllServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request , HttpServletResponse response)
			throws ServletException , IOException {
//		Locale languageType=request.getLocale();//获取用户语言  
//		String localIp=request.getLocalAddr();//获取本地ip  
//		int localPort=request.getLocalPort();//获取本地的端口  
//		String localName=request.getLocalName();//获取本地计算机的名字  
//		System.out.println("本机名称：" + localName);
//		System.out.println("本地IP：" + localIp);
//		System.out.println("本地端口" + localPort);
//		System.out.println("用户语言：" +languageType);
//		
//		String requestURL=request.getRequestURL().toString();//获取除参数之外的地址信息
//		String queryString=request.getQueryString();
//		System.out.println("请求的地址->"+requestURL);
//		System.out.println("请求的地址后的信息->"+queryString);
		request.setCharacterEncoding("utf-8");
		//获取请求资源路径并加以处理
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if(("/add").equals(action)){
			//获取页面传入的数据
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");
			//将数据插入到数据库中
			IEmpService ies = ServiceFactory.getIEmpServiceInstance();
			Emp emp = new Emp();
			emp.setName(name);
			emp.setSalary(Float.parseFloat(salary));
			emp.setAge(Integer.parseInt(age));
			try {
				ies.insert(emp);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(("/del").equals(action)){
			String id = request.getParameter("id");
			IEmpService ies = ServiceFactory.getIEmpServiceInstance();
			
			try {
				ies.delete(Integer.parseInt(id));
				response.sendRedirect("list.do");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(("/modify").equals(action)){
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");
			String id = request.getParameter("id");
			Emp emp = new Emp();
			emp.setName(name);
			emp.setSalary(Float.parseFloat(salary));
			emp.setAge(Integer.parseInt(age));
			emp.setId(Integer.parseInt(id));
			IEmpService ies = ServiceFactory.getIEmpServiceInstance();
			try {
				ies.update(emp);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(("/list").equals(action)){
			//查询出所有的成员信息
			IEmpService ies = ServiceFactory.getIEmpServiceInstance();
			try {
				List<Emp> list = ies.query();
				request.setAttribute("emps",list);
				request.getRequestDispatcher("list1.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
//				//转发到异常处理页面
//				request.setAttribute("msg", "系统繁忙，请联系管理员！");
//				request.getRequestDispatcher("error.jsp").forward(request, response);
				//异常交给容器处理(将e包装成ServletException并抛出)
				throw new ServletException(e);
			}
		}else if(("/alter").equals(action)){
			//先生成一个修改信息的页面
			String id = request.getParameter("id");
			Connection conn = DatabaseConnect.getConnection();
			IEmpDao ied = DaoFactory.getIEmpDaoInstance(conn);
			try {
				Emp emp = ied.selectById(Integer.parseInt(id));
				//转发
				request.setAttribute("emp", emp);
				request.getRequestDispatcher("alter.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e);
			}finally{
				DatabaseConnect.close(conn);
			}
		}
	}
}
