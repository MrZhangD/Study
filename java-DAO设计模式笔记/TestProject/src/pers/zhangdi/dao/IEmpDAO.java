package pers.zhangdi.dao;

import pers.zhangdi.vo.Emp;
//IEmpDAO接口继承顶层IDAO接口，其余方法可以再自己定义
public interface IEmpDAO extends IDAO<Integer , Emp> {
	
}
