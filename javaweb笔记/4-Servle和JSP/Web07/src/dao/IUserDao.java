package dao;

import java.sql.SQLException;

import vo.User;

public interface IUserDao {
	/**
	 * 根据username查询用户
	 * @param username	
	 * @return	返回User对象
	 * @throws SQLException
	 */
	public User findByUsername(String username) throws SQLException;
	
	/**
	 * 添加用户
	 * @param user
	 * @return	true/false
	 * @throws SQLException
	 */
	public boolean doAdd(User user) throws SQLException;
	
	/**
	 * 删除用户
	 * @param id
	 * @return	true/false
	 * @throws SQLException
	 */
	public boolean doDelete(Integer id) throws SQLException;
	
	/**
	 * 修改用户
	 * @param user
	 * @return	true/false
	 * @throws SQLException
	 */
	public boolean doUpdate(User user) throws SQLException;
}