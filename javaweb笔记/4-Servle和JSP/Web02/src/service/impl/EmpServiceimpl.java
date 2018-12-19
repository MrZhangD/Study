package service.impl;

import java.sql.Connection;
import java.util.List;

import service.IEmpService;
import sqlConn.DatabaseConnect;
import vo.Emp;
import dao.IEmpDao;
import factory.DaoFactory;

public class EmpServiceimpl implements IEmpService{
	Connection conn = DatabaseConnect.getConnection();
	
	@Override
	//添加数据
	public boolean insert(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		try {
			IEmpDao ied = DaoFactory.getIEmpDaoInstance(conn);
			if(ied.selectById(emp.getId()) == null){
				return ied.doAdd(emp);
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			DatabaseConnect.close(conn);
		}
	}

	@Override
	//删除数据
	public boolean delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			IEmpDao ied = DaoFactory.getIEmpDaoInstance(conn);
			if(ied.selectById(id) != null){
				return ied.doDelete(id);
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			DatabaseConnect.close(conn);
		}
	}

	@Override
	//修改
	public boolean update(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		try {
			IEmpDao ied = DaoFactory.getIEmpDaoInstance(conn);
			return ied.doUpdate(emp);
		} catch (Exception e) {
			// TODO: handle exception
			throw e ;
		}finally{
			DatabaseConnect.close(conn);
		}
	}

	@Override
	//查询全部
	public List<Emp> query() throws Exception {
		// TODO Auto-generated method stub
		try {
			IEmpDao ied = DaoFactory.getIEmpDaoInstance(conn);
			return ied.selectAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw e ;
		}finally{
			DatabaseConnect.close(conn);
		}
	}
}
