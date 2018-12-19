package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Emp;
import dao.IEmpDao;

//DAO实现类
public class EmpDaoipml implements IEmpDao{
	private Connection conn;
	private PreparedStatement ps ;
	
	/**
	 * @param conn		标识数据库的连接对象
	 */
	public EmpDaoipml(Connection conn){
		this.conn = conn;
	}
	
	@Override
	//添加数据
	public boolean doAdd(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false ;
		String sql = "insert into staff values(?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, emp.getName());
		ps.setFloat(2, emp.getSalary());
		ps.setInt(3, emp.getAge());
		ps.setInt(4, emp.getId());
		if(ps.executeUpdate() != 0)
			flag = true ;
		return flag;
	}

	@Override
	//删除数据(根据id)
	public boolean doDelete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false ;
		String sql = "delete from sraff where id=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		if(ps.executeUpdate() != 0)
			flag = true;
		return flag;
	}

	@Override
	//修改数据
	public boolean doUpdate(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		boolean flag  = false ;
		String sql = "update staff set name=?,salary=?,age=? WHERE id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, emp.getName());
		ps.setFloat(2, emp.getSalary());
		ps.setInt(3, emp.getAge());
		ps.setInt(4, emp.getId());
		if(ps.executeUpdate() != 0)
			flag = true;
		return flag;
	}

	@Override
	//查询全部数据
	public List<Emp> selectAll() throws Exception {
		// TODO Auto-generated method stub
		Emp emp = null;
		List<Emp> list = new ArrayList<Emp>();
		
		String sql = "select * from staff";
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			emp = new Emp();
			emp.setName(rs.getString(1));
			emp.setSalary(rs.getFloat(2));
			emp.setAge(rs.getInt(3));
			emp.setId(rs.getInt(4));
			list.add(emp);
		}
		return list;
	}

	@Override
	//按id查询雇员
	public Emp selectById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Emp emp = null ;
		String sql = "select * from staff where id=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			emp = new Emp();
			emp.setName(rs.getString(1));
			emp.setSalary(rs.getFloat(2));
			emp.setAge(rs.getInt(3));
			emp.setId(rs.getInt(4));
		}
		return emp;
	}
	
}
