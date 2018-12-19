package pers.zhangdi.service.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

import pers.zhangdi.dbc.DatabaseConnection;
import pers.zhangdi.factory.DAOFactory;
import pers.zhangdi.service.IDeptService;
import pers.zhangdi.vo.Dept;
//部门表 的 业务实现类
public class DeptServiceImpl implements IDeptService {
	private DatabaseConnection dbc = new DatabaseConnection() ;
	@Override
	//增加部门
	public boolean insert(Dept vo) throws Exception {
		try {
			Connection conn = dbc.getConnection() ;
			if(DAOFactory.getIDeptDAOInstance(conn).findById(vo.getDeptno()) == null) {
				return DAOFactory.getIDeptDAOInstance(conn).doCreat(vo) ;
			}
			return false ;
		}catch(Exception e) {
			throw e ;
		}finally {
			dbc.close();
		}
	}

	@Override
	//修改部门数据
	public boolean update(Dept vo) throws Exception {
		try {
			Connection conn = dbc.getConnection() ;
			return DAOFactory.getIDeptDAOInstance(conn).doUpdate(vo) ;
		}catch(Exception e) {
			throw e ;
		}finally {
			dbc.close(); 
		}
	}

	@Override
	//删除数据
	public boolean delete(Set<Integer> ids) throws Exception {
	try {
			Connection conn = dbc.getConnection() ;
			return DAOFactory.getIDeptDAOInstance(conn).doRemoveBatch(ids) ;
		}catch(Exception e) {
			throw e ;
		}finally {
			dbc.close(); 
		}
	}

	@Override
	//查询全部部门信息
	public List<Dept> list() throws Exception {
	try {
			return DAOFactory.getIDeptDAOInstance(dbc.getConnection()).findAll() ;
		}catch(Exception e) {
			throw e ;
		}finally {
			dbc.close(); 
		}
	}

	@Override
	//按照id查询部门信息
	public Dept get(int id) throws Exception {
	try {
			return DAOFactory.getIDeptDAOInstance(dbc.getConnection()).findById(id) ;
		}catch(Exception e) {
			throw e ;
		}finally {
			dbc.close(); 
		}
	}

}
