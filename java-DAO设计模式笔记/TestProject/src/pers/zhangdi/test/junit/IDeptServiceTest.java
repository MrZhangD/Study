package pers.zhangdi.test.junit;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;
import pers.zhangdi.factory.ServiceFactory;
import pers.zhangdi.vo.Dept;

public class IDeptServiceTest {

	@Test
	//插入测试
	public void testInsert() {
		Dept dept = new Dept() ;
		dept.setDeptno(123);
		dept.setDname("员工部");
		dept.setLoc("北京");
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().insert(dept));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	//修改测试
	public void testUpdate() {
		Dept dept = new Dept() ;
		dept.setDeptno(123);
		dept.setDname("员工部");
		dept.setLoc("青岛");
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().update(dept));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	//删除测试
	public void testDelete() {
		Set<Integer> ids = new HashSet<Integer>() ;
		ids.add(222) ;
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().delete(ids));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	//全部查询操作
	public void testList() {
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().list().size() > 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	//按照id查询部门操作
	public void testGet() {
		try {
			TestCase.assertNotNull(ServiceFactory.getIDeptServiceInstance().get(111));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
