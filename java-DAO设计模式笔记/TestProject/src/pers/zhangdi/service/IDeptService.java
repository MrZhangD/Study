package pers.zhangdi.service;

import java.util.List;
import java.util.Set;

import pers.zhangdi.vo.Dept;

//部门的业务层接口
public interface IDeptService {
	public boolean insert(Dept vo) throws Exception ;
	public boolean update(Dept vo) throws Exception ;
	public boolean delete(Set<Integer> ids) throws Exception ;
	public List<Dept> list() throws Exception ;
	public Dept get(int id) throws Exception ;
}
