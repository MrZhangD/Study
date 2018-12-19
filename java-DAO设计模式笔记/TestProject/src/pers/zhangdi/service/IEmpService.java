package pers.zhangdi.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import pers.zhangdi.vo.Emp;

/**
 * 定义emp表的业务层执行标准，此类一定要负责数据库的打开和关闭操作
 * 此类可以通过DAOFactory工厂类来获得IEmpDAO接口对象
 * @author MR.zhang
 *
 */
public interface IEmpService {
	/**
	 * 实现雇员数据的增加操作，本次操作要调用IEmpDAO接口的如下方法：
	 * （1）需要调用IEmpDAO.findById(Integer id)方法，判断要增加的数据是否存在
	 * （2）如果不存在则调用IEmpDAO.doCreat(Emp vo)方法，返回操作结果
	 * @param vo	包含了要增加 数据的vo对象 
	 * @return		如果增加数据的ID重复或者保存失败则返回false，否则返回true
	 * @throws Exception	SQl执行异常
	 */
	public boolean insert(Emp vo)throws Exception ;
	
	/**
	 * 实现雇员数据的修改操作，本次调用IEmoDAO.doUpdate(Emp vo)方法，本次修改属于全部内容 的修改
	 * @param vo	包含了要修改数据的vo对象
	 * @return		修改成功返回true，修改失败返回false
	 * @throws Exception	SQL执行异常
	 */
	public boolean update(Emp vo)throws Exception ;
	
	/**
	 * 执行雇员的删除操作，可以删除多个雇员的信息，调用IEmpDAO.doRemoveBatch(Set<Integer> ids)方法
	 * @param ids	包含了全部要删除的数据的集合，没有重复数据
	 * @return		删除成功返回true ，删除失败返回false
	 * @throws Exception	SQl执行异常
	 */
	public boolean delete(Set<Integer> ids)throws Exception ;

	/**
	 * 根据编号查找雇员的完整信息，调用IEmpDAO.findById(Integer id)方法
	 * @param id	要查找的固原的编号
	 * @return		如果找到返回Emp对象，找不到返回null
	 * @throws Exception	SQL执行异常
	 */
	public Emp select(Integer id)throws Exception ;

	/**
	 * 查询全部雇员的信息 ， 调用IEmpDAO.findAll()方法 ;
	 * @return	查询结果以list集合的形式返回，若没有数据则集合长度为0	
	 * @throws Exception
	 */
	public List<Emp> selectAll()throws Exception ;
	
	/**
	 * 实现数据的模糊查询与数据统计，要调用IEmpDAO接口的两个方法：
	 * （1）调用IEmpDAO.findAllSplit(Integer currentPage, Integer lineSize, String column, String keyword)方法 ， 查询出所有的表数据，返回List<Emp> ;
	 * （2）调用IEmpDAO.getCount(String column, String keyword)方法，查询出所有的数据量，返回Integer
	 * @param currentPage	当前页
	 * @param lineSize		每一页的数据行数
	 * @param column		模糊查询的数据列
	 * @param keyword		模糊查询的关键字
	 * @return		本方法返回多种数据类型，所以使用Map集合返回，由于类型不统一，所以所有的value设置为Object
	 */
	public Map<String , Object> like(int currentPage , int lineSize , String column , String keyword)throws Exception ;
	
	
}
