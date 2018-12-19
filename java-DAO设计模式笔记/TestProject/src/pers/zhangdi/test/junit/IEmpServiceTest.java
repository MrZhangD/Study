package pers.zhangdi.test.junit;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;
import pers.zhangdi.factory.ServiceFactory;
import pers.zhangdi.vo.Emp;

public class IEmpServiceTest {
	//生成随机的empno码进行测试
	@SuppressWarnings("unused")
	private static int empno ;
	static {
		empno = new Random().nextInt(10000) ;
	}
	
	@Test
	//插入测试
	public void testInsert() {
		Emp emp = new Emp()  ;
		emp.setEmpno(1111);
		emp.setEname("姓名——" + 1111);
		emp.setJob("职位——" + 1111);
		emp.setHiredate(new Date());
		emp.setSal(1020.0);
		emp.setComm(20300.0);
		//如果括号里的结果为True，则测试通过
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().insert(emp)) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Test
	//修改测试
	public void testUpdate() {
		Emp emp = new Emp()  ;
		emp.setEmpno(1005);
		emp.setEname("姓名——" + 1005);
		emp.setJob("JOB——" + 1005);
		emp.setHiredate(new Date());
		emp.setSal(1020.0);
		emp.setComm(20300.0);
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().update(emp));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	//删除测试
	public void testDelete() {
		Set<Integer> ids = new HashSet<Integer>() ;
		ids.add(1222) ;
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().delete(ids));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	//查询测试
	public void testSelect() {
		try {
			TestCase.assertNotNull(ServiceFactory.getIEmpServiceInstance().select(1005));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	//查询全部数据测试
	public void testSelectAll() {
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().selectAll().size() > 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	//模糊查询测试
	public void testLike() {
		try {
			Map<String , Object> map = new HashMap<String, Object>() ;
			map = ServiceFactory.getIEmpServiceInstance().like(1, 5, "ename" , "小") ;
			int count = (Integer) map.get("empcount") ;
			List<Emp> list = (List<Emp>) map.get("allEmps") ;
			TestCase.assertTrue(count > 0 && list.size() > 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
