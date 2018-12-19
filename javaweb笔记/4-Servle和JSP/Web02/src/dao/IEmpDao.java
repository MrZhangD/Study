package dao;

import java.util.List;
import vo.Emp;

/**
 * @author MR.zhang
 *	定义泛型的DAO接口，对EMP表的功能包括：增加，删除，修改,查询
 */
public interface IEmpDao{
	/**
	 * 实现数据的添加操作
	 * @param emp	包含了要增加数据的emp对象
	 * @return		添加成功返回true，失败返回false
	 * @throws Exception	SQL执行异常
	 */
	public boolean doAdd(Emp emp)throws Exception;
	
	/**
	 * 实现数据的删除操作
	 * @param id	要删除数据的id
	 * @return		成功返回true，失败返回false
	 * @throws Exception	SQL执行异常
	 */
	public boolean doDelete(Integer id)throws Exception;
	
	/**
	 * 实现数据的修改操作
	 * @param emp	要修改的emp对象	
	 * @return		成功返回true，失败返回false
	 * @throws Exception	SQL执行异常
	 */
	public boolean doUpdate(Emp emp)throws Exception;
	
	/**
	 * 实现该表全部数据的查询操作
	 * @return	返回由查询对象组成的List对象
	 * @throws Exception	SQL执行异常
	 */
	public List<Emp> selectAll()throws Exception;
	
	/**
	 * 按id查询相应雇员
	 * @param id	要查询的数据的id
	 * @return		返回查询到的Emp对象
	 */
	public Emp selectById(Integer id)throws Exception;
}
