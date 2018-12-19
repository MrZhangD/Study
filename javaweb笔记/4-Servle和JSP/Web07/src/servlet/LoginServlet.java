package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.User;
import dao.IUserDao;
import dao.impl.UserDaoimpl;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8") ;
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		IUserDao iu = new UserDaoimpl();
		try {
			User user = iu.findByUsername(username);
			if(user != null && (pwd).equals(user.getPassword())){
				//登录成功绑定session(并且设置超时时间为20秒)
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(20);
				//用户名存在并且密码符合
				response.sendRedirect("success.jsp");
			}else{
				//登录失败
				request.setAttribute("login_failed", "用户名或密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
