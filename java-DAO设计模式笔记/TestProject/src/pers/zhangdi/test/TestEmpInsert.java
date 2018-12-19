package pers.zhangdi.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import pers.zhangdi.factory.ServiceFactory;
import pers.zhangdi.vo.Emp;

//测试向emp表中插入数据
public class TestEmpInsert {
	public static void main(String[] args) throws ParseException {
		Emp emp = new Emp() ;
		emp.setEmpno(1005);
		emp.setEname("小gg");
		emp.setJob("撒");
		emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-10-12"));
		emp.setSal(1020.0);
		emp.setComm(20300.0);
		//调用业务层进行操作
		try {
			System.out.println(ServiceFactory.getIEmpServiceInstance().insert(emp));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
