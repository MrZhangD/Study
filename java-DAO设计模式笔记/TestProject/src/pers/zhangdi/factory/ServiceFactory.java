package pers.zhangdi.factory;

import pers.zhangdi.service.IDeptService;
import pers.zhangdi.service.IEmpService;
import pers.zhangdi.service.impl.DeptServiceImpl;
import pers.zhangdi.service.impl.EmpServiceImpl;

//业务层工厂类；其它层调用业务层的时候，通过业务层工厂类获得业务层的接口对象=-》IEmpService接口对象
public class ServiceFactory {
	public static IEmpService getIEmpServiceInstance() {
		IEmpService ies = new EmpServiceImpl() ;
		return ies ;
	}
	public static IDeptService getIDeptServiceInstance() {
		return new DeptServiceImpl() ;
	}
}
