package pers.zhangdi.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pers.zhangdi.factory.ServiceFactory;
import pers.zhangdi.service.IEmpService;
import pers.zhangdi.vo.Emp;

//分页模糊查询测试

public class TestEmpSplit {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			//通过业务层的工厂类 来获取业务层的接口对象，进而操控业务层完成操作
			IEmpService ies = ServiceFactory.getIEmpServiceInstance() ; 
			Map<String , Object> map = ies.like(1, 5, "ename", "小") ;
			
			System.out.println("查询到的数据量：" + map.get("empcount"));
			List<Emp> list = (List<Emp>) map.get("allEmps") ;	//将查询后保存在map（map中保存的是List集合对象）中的List集合（List集合中保存的是Emp对象）取出来赋给list
			Iterator<Emp> its = list.iterator() ;		//使用Iterator进行集合的输出
			while(its.hasNext()) {
				Emp emp = its.next() ;
				System.out.println(emp.getEmpno() + "\t" + emp.getEname() + "\t" + emp.getJob());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
