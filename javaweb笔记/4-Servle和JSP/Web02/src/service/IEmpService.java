package service;

import java.util.List;

import vo.Emp;

/**
 * 定义emp表的业务层执行标准，此类一定要负责数据库的打开和关闭操作
 * 此类可以通过DAOFactory工厂类来获得IEmpDAO接口对象
 * @author MR.zhang
 */
public interface IEmpService {
	/**
	 * 实现雇员的添加操作，本次要调用的IEmpDao接口的如下方法：
	 * （1）IEmpDao.selectById(Integer id);	判断要增加的数据是否已经存在
	 * （2）IEmpDao.doAdd(Emp emp);	如不错在调用此方法，并返回操作结果
	 * @param emp	要添加数据的emp对象
	 * @return		添加成功返回true，失败返回false
	 * @throws Exception	SQL执行异常
	 */
	public boolean insert(Emp emp)throws Exception;
	/**
	 * 实现雇员的删除操作，本次调用的IEmpDao接口的如下方法：
	 * （1）IEmpDao.selectById(Integer id);	判断要删除的数据是否存在
	 * （2）IEmpDao.doDelete(Integer id);	如存在，则调用方法，并返回操作结果
	 * @param id	要删除数据的id
	 * @return		成功返回true，失败返回false
	 * @throws Exception	SQL执行异常
	 */
	public boolean delete(Integer id)throws Exception;
	
	/**
	 * 实现雇员的修改操作，本次调用IEmpDao接口的如下方法
	 * （1）IEmpDao.doUpdate(Emp emp);
	 * @param emp	要修改的emp对象	
	 * @return		返回true
	 * @throws Exception	SQL执行异常
	 */
	public boolean update(Emp emp)throws Exception;
	
	/**
	 * 查询emp表中的全部雇员信息，本次调用IEmpDao接口下的如下方法：
	 * （1）IEmpDao.selectAll();
	 * @return		查询结果以list集合的形式返回，若没有数据则集合长度为0
	 * @throws Exception
	 */
	public List<Emp> query()throws Exception;
}
