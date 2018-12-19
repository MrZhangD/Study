package factory;

import java.sql.Connection;
import dao.IEmpDao;
import dao.impl.EmpDaoipml;

/**
 * @author MR.zhang
 *	业务层要想进行数据层的调用，那么必须要取得IEmpDAO接口对象，
 *	但是不同层之间要想取得接口对象实例，需要使用工厂设计模式。
 */
public class DaoFactory {
	public static IEmpDao getIEmpDaoInstance(Connection conn){
		return new EmpDaoipml(conn);
	}
}
