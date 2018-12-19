package pers.zhangdi.factory;

import java.sql.Connection;

import pers.zhangdi.dao.IDeptDAO;
import pers.zhangdi.dao.IEmpDAO;
import pers.zhangdi.dao.impl.DeptDAOimpl;
import pers.zhangdi.dao.impl.EmpDAOimpl;
//工厂类：给业务层提供IEmpDAO接口对象
public class DAOFactory {
	public static IEmpDAO getIEmpDAOInstance(Connection conn) {
		return new EmpDAOimpl(conn) ;
	}
	//部门表的接口对象提供方法
	public static IDeptDAO getIDeptDAOInstance(Connection conn) {
		return new DeptDAOimpl(conn) ;
	}
}
