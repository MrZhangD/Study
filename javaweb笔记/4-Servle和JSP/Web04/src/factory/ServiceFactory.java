package factory;

import service.IEmpService;
import service.impl.EmpServiceimpl;

//业务工厂类：其它层调用业务层时，通过业务层工厂类获得业务层的接口对象——>IEmpService接口对象
public class ServiceFactory {
	public static IEmpService getIEmpServiceInstance(){
		return new EmpServiceimpl();
	} 
}
