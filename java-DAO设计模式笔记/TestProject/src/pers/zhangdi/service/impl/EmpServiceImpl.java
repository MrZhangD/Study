package pers.zhangdi.service.impl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pers.zhangdi.dao.IEmpDAO;
import pers.zhangdi.dbc.DatabaseConnection;
import pers.zhangdi.factory.DAOFactory;
import pers.zhangdi.service.IEmpService;
import pers.zhangdi.vo.Emp;
//雇员的业务层实现类
public class EmpServiceImpl implements IEmpService{
	//在这个类的对象就提供有一个数据库连接类的实例化对象
	private DatabaseConnection dbc = new DatabaseConnection() ;
	
	@Override
	//增加雇员
	public boolean insert(Emp vo) throws Exception {
		try {
			Connection conn = dbc.getConnection() ;		//业务层获得数据库连接对象	：打开了数据库
			//业务层通过工厂类获得 DAO接口 对象		：可以使用数据层的接口对象操纵数据层的原子操作从而完成业务层的操作
			IEmpDAO ied = DAOFactory.getIEmpDAOInstance(conn); 		//因为工厂类中的getIEmpDAOInstance()方法是static方法，所以不不用被实例化就能被调用
			//判断是否emp表中已有要添加的雇员，如果没有(null)则进行添加，如果有则返回false
			if(ied.findById(vo.getEmpno()) == null) {
				return ied.doCreat(vo) ;
			}
			return false ;
		}catch(Exception e) {
			throw e ;
		}finally {
			this.dbc.close();		//数据库关闭
		}
	}

	@Override
	//修改雇员的信息
	public boolean update(Emp vo) throws Exception {
		try {
			Connection conn = dbc.getConnection() ;		//获取数据库连接对象	：开启数据库
			//业务层获取数据层的接口对象，：从而使业务层能够操纵数据层的原子操作完成业务层的操作
			IEmpDAO ied = DAOFactory.getIEmpDAOInstance(conn) ;
			//实施修改操作
			return ied.doUpdate(vo) ;
		}catch(Exception e) {
			throw e ;
		}finally {
			dbc.close();
		}
	}

	@Override
	//批量删除雇员
	public boolean delete(Set<Integer> ids) throws Exception {
		try {
			Connection conn = dbc.getConnection() ;
			IEmpDAO ied = DAOFactory.getIEmpDAOInstance(conn) ;
			return ied.doRemoveBatch(ids) ;
		}catch(Exception e) {
			throw e ;
		}finally {
			dbc.close();
		}
	}

	@Override
	//通过雇员编号查询 雇员
	public Emp select(Integer id) throws Exception {
		try {
			Connection conn = dbc.getConnection() ;
			return DAOFactory.getIEmpDAOInstance(conn).findById(id) ;
		} catch (Exception e) {
			throw e ;
		}finally {
			dbc.close() ;
		}
	}

	@Override
	//查询全部雇员
	public List<Emp> selectAll() throws Exception {
		try {
			Connection conn = dbc.getConnection() ;
			return DAOFactory.getIEmpDAOInstance(conn).findAll() ;
		} catch (Exception e) {
			throw e ;
		}finally {
			dbc.close();
		}
	}

	@Override
	//模糊查询本页的雇员信息，并统计查询的数据量
	public Map<String, Object> like(int currentPage, int lineSize, String column, String keyword)throws Exception {
		try {
			Connection conn = dbc.getConnection() ;
			Map<String , Object> map = new HashMap<String, Object>() ;
			List<Emp> list = DAOFactory.getIEmpDAOInstance(conn).findAllSplit(currentPage, lineSize, column, keyword) ;
			Integer count = DAOFactory.getIEmpDAOInstance(conn).getAllCount(column, keyword) ;
			map.put("allEmps", list) ;
			map.put("empcount", count) ;
			return map ;
		} catch (Exception e) {
			throw e ;
		}finally {
			dbc.close();
		}
	}
}
