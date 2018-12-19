package bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<User> list = new ArrayList<User>();
		for(int i = 0 ; i <= 10 ; i++){
			User user = new User();
			user.setName("00" + i);
			user.setAge(16 + 2*i);
			if(i%2 == 0){
				user.setSex("m");
			}else{
				user.setSex("w");
			}
			list.add(user);
		}
		request.setAttribute("users", list);
		request.getRequestDispatcher("demo1.jsp").forward(request, response);
	}
}
