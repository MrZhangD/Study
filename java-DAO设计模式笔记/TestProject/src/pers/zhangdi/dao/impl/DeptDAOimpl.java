package pers.zhangdi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import pers.zhangdi.dao.IDeptDAO;
import pers.zhangdi.vo.Dept;

public class DeptDAOimpl implements IDeptDAO {
	Connection conn ;
	PreparedStatement ps ;
	
	/**
	 * 如果要想使用数据层进行原子性的功能操作实现，必须提供有Connection接口对象
	 * 另外，由于开发中业务层要调用数据层，所以数据库的打开和关闭都交给业务层处理
	 * @param conn
	 */
	public DeptDAOimpl(Connection conn) {
		this.conn = conn ;
	}
	//增加部门
	public boolean doCreat(Dept vo) throws Exception {
		boolean flag = false ;
		String sql= "insert into dept values(?,?,?)" ;
		ps = conn.prepareStatement(sql) ;
		ps.setInt(1, vo.getDeptno());
		ps.setString(2, vo.getDname());
		ps.setString(3, vo.getLoc());
		if(ps.executeUpdate() > 0) {
			flag = true ;
		}
		return flag;
	}

	@Override
	//修改部门数据
	public boolean doUpdate(Dept vo) throws Exception {
		boolean flag = false ;
		String sql= "update dept set dname = ? , loc = ? where deptno = ?" ;
		ps = conn.prepareStatement(sql) ;
		ps.setString(1, vo.getDname());
		ps.setString(2, vo.getLoc());
		ps.setInt(3, vo.getDeptno());
		if(ps.executeUpdate() > 0) {
			flag = true ;
		}
		return flag;
	}

	@Override
	//批量删除
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		boolean flag = false ;
		int i = 0 ;
		String sql = "delete from dept where deptno = ?" ;
		Iterator<Integer> its = ids.iterator() ;
		while(its.hasNext()) {
			ps = conn.prepareStatement(sql) ;
			ps.setInt(1, its.next());
			if(ps.executeUpdate() > 0)
				i++  ;
		}
		if(i == ids.size())
			flag = true ;
		return flag;
	}

	@Override
	//根据编号查询 部门数据
	public Dept findById(Integer id) throws Exception {
		Dept dept = null ;
		String sql = "select * from dept where deptno = ?" ;
		ps = conn.prepareStatement(sql) ;
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery() ;
		if(rs.next()) {
			dept = new Dept() ;
			dept.setDeptno(rs.getInt(1));
			dept.setDname(rs.getString(2));
			dept.setLoc(rs.getString(3));
		}
		return dept;
	}

	@Override
	//查询全部部门数据并以集合 的形式返回
	public List<Dept> findAll() throws Exception {
		List<Dept> list = new ArrayList<Dept>() ;
		String sql = "select * from dept" ;
		ps = conn.prepareStatement(sql) ;
		ResultSet rs = ps.executeQuery() ;
		while(rs.next()) {
			Dept dept = new Dept() ;
			dept.setDeptno(rs.getInt(1));
			dept.setDeptno(rs.getInt(1));
			dept.setDname(rs.getString(2));
			dept.setLoc(rs.getString(3));
			list.add(dept) ;
		}
		return list;
	}

	@Override
	//分页查询
	public List<Dept> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyword)
			throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("此方法未实现") ;
	}

	@Override
	public Integer getAllCount(String column, String keyword) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("此方法未实现") ;
	}

}
