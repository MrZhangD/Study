package pers.zhangdi.dao.impl;
import java.sql.Connection;
import java.sql.Date;
//数据层实现类（DAO实现类）
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import pers.zhangdi.dao.IEmpDAO;
import pers.zhangdi.vo.Emp;

public class EmpDAOimpl implements IEmpDAO {
	private Connection conn ;			//需要利用Connection对象操作
	private PreparedStatement ps ;		
	
	/**
	 * 如果要想使用数据层进行原子性的功能操作实现，必须提供有Connection接口对象
	 * 另外，由于开发中业务层要调用数据层，所以数据库的打开和关闭都交给业务层处理
	 * @param conn	标识数据库的连接对象
	 */
	public EmpDAOimpl(Connection conn) {
		this.conn = conn ;
	}
	
	@Override
	//实现数据的增加操作
	public boolean doCreat(Emp vo) throws Exception {
		boolean flag = false ;
		String sql = "insert into emp values(?,?,?,?,?,?)" ;
		ps = conn.prepareStatement(sql) ;
		ps.setInt(1 , vo.getEmpno());
		ps.setString(2 , vo.getEname());
		ps.setString(3, vo.getJob());
		ps.setDate(4 , new Date(vo.getHiredate().getTime()));		//注意java中的时间与数据库中的时间的转换
		ps.setDouble(5 , vo.getSal());
		ps.setDouble(6 , vo.getComm());
		if(ps.executeUpdate() > 0)
			flag = true ;
		return flag;
	}

	@Override
	//实现数据的修改操作(根据雇员编号)
	public boolean doUpdate(Emp vo) throws Exception {
		boolean flag = false ;
		String sql = "UPDATE emp SET  ename = ? , job  = ? , hiredate = ? , sal = ? , comm = ? WHERE empno = ?" ;
		ps = conn.prepareStatement(sql) ;
		ps.setString(1 , vo.getEname());
		ps.setString(2, vo.getJob());
		ps.setDate(3 , new Date(vo.getHiredate().getTime()));		//注意java中的时间与数据库中的时间的转换
		ps.setDouble(4 , vo.getSal());
		ps.setDouble(5 , vo.getComm());
		ps.setInt(6 , vo.getEmpno());
		if(ps.executeUpdate() > 0)
			flag = true ;
		return flag;
	}

	@Override
	//批量删除数据 （根据雇员的编号）
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		boolean flag = false ;
		int i = 0 ;
		String sql = "DELETE FROM emp WHERE empno = ?" ;
		Iterator<Integer> it = ids.iterator() ;
		while(it.hasNext()) {
			ps = conn.prepareStatement(sql) ;
			ps.setInt(1, it.next());
			if(ps.executeUpdate() > 0)
				i++ ;
		}
		if(i == ids.size())
			flag = true ;
		return flag;
	}

	@Override
	//按照雇员编号查找指定的雇员信息
	public Emp findById(Integer id) throws Exception {
		Emp emp = null ;
		String sql = "select * from emp where empno = ?" ;
		ps = conn.prepareStatement(sql) ;
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery() ;
		if(rs.next()) {
			emp = new Emp() ;
			emp.setEmpno(rs.getInt(1));
            emp.setEname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setHiredate(rs.getDate(4));
            emp.setSal(rs.getDouble(5));
            emp.setComm(rs.getDouble(6));
		}
		return emp;		//之所以在开头声明Emp对象却if语句里实例化对象，是因为return的是一个Emp对象
						//这样就可以保证如果查找的雇员编号不存在，仍能返回Emp对象，只不过返回的是一个空的emp，就是查询不到
	}

	@Override
	//查询数据表的所有信息，并且以集合的形式返回
	public List<Emp> findAll() throws Exception {
		Emp emp = null ;
		List<Emp> list = new ArrayList<Emp>() ;
		String sql = "select * from emp" ;
		ps = conn.prepareStatement(sql) ;
		ResultSet rs = ps.executeQuery() ;
		while(rs.next()) {
			emp = new Emp() ;
			emp.setEmpno(rs.getInt(1));
            emp.setEname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setHiredate(rs.getDate(4));
            emp.setSal(rs.getDouble(5));
            emp.setComm(rs.getDouble(6));
            list.add(emp) ;
		}
		return list;
	}

	@Override
	//分页进行数据的模糊查询，查询结果以集合的形式返回
	public List<Emp> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyword)
			throws Exception {			//currentPage:当前所在的页		lineSize:每页要显示的数据行数
										//column:要进行模糊查询的数据列		keyword：模糊查询的关键词
		Emp emp = null ;
		List<Emp> list = new ArrayList<Emp>() ;
		String sql = "select * from" + "(select empno,ename,job,hiredate,sal,comm,(SELECT COUNT(*) FROM emp)cn from emp "
					+"where " + column + " like ? and (SELECT COUNT(*) FROM emp) <= ?)temp " + "where temp.cn > ?" ;
		ps = conn.prepareStatement(sql) ;
		ps.setString(1, "%" + keyword + "%");
		ps.setInt(2, currentPage*lineSize);
		ps.setInt(3, (currentPage-1)*lineSize);
		ResultSet rs = ps.executeQuery() ;
		while(rs.next()) {
			emp = new Emp() ;
			emp.setEmpno(rs.getInt(1));
            emp.setEname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setHiredate(rs.getDate(4));
            emp.setSal(rs.getDouble(5));
            emp.setComm(rs.getDouble(6));
            list.add(emp) ;
		}
		return list;
	}

	@Override
	//进行模糊查询数据量的统计，如果表中没有记录统计的结果就是0
	public Integer getAllCount(String column, String keyword) throws Exception {
		Integer count = 0 ;
		String sql = "select count(empno) from emp where " + column + " like ?" ;
		ps = conn.prepareStatement(sql) ;
		ps.setString(1, ("%" + keyword + "%"));
		ResultSet rs = ps.executeQuery() ;
		if(rs.next())
			count = rs.getInt(1);
		return count;
	}
	
}
