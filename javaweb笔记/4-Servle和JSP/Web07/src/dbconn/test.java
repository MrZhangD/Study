package dbconn;

import java.sql.SQLException;

import vo.User;
import dao.IUserDao;
import dao.impl.UserDaoimpl;

public class test {
	public static void main(String[] args) throws SQLException {
		IUserDao iu = new UserDaoimpl();
		User user = iu.findByUsername("admin");
		System.out.println(user.toString());
	}
}
