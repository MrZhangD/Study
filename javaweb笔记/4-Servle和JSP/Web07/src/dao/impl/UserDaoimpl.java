package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.User;
import dao.IUserDao;
import dbconn.DatabaseConnection;

public class UserDaoimpl implements IUserDao{
	Connection conn = null ;
	PreparedStatement ps = null ;
	
	public UserDaoimpl(){
		this.conn = DatabaseConnection.getConnection();
	}
	@Override
	public User findByUsername(String username) throws SQLException {
		String sql = "select * from user where username = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		User user = null ;
		if(rs.next()){
			user = new User() ;
			user.setId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setName(rs.getString(4));
			user.setSex(rs.getString(5));
		}
		return user;
	}

	@Override
	public boolean doAdd(User user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(User user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
