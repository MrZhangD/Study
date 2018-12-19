package pers.zhangdi.dao;

import java.util.List;
import java.util.Set;

//公共DAO接口（顶层DAO接口）:使用泛型接口
/**
 * 定义公共的DAO接口，基本的功能包括：增加，修改全部，删除数据，根据编号查询，查询全部，分页显示，数据统计
 * @author MR.zhang
 *
 * @param <K>	表示要操作的主键类型，由子接口实现
 * @param <V>	表示要操作 的vo类型，由子接口实现
 */
public interface IDAO<K , V> {
	/**
	 * 实现数据的增加操作
	 * @param vo	包含了要增加数据的vo对象
	 * @return		数据保存成功就返回true，失败就返回false
	 * @throws Exception	SQL执行异常
	 */
	public boolean doCreat(V vo) throws Exception ;
	/**
	 * 实现数据的修改操作，本次修改是根据ID进行全部字段数据的修改
	 * @param vo	包含了要修改数据的信息，一定要提供有ID内容
	 * @return		修改成功返回true ， 失败返回false
	 * @throws Exception	SQL执行异常
	 */
	public boolean doUpdate(V vo) throws Exception ;
	/**
	 * 执行数据的批量删除操作，所有要删除的数据以Set集合的形式保存
	 * @param ids	包含了所有要删除的数据ID，不包含有重复的数据
	 * @return		删除成功返回true（删除数据个数与 要删除数据个数相同） ， 否则返回false
	 * @throws Exception	SQL执行异常
	 */
	public boolean doRemoveBatch(Set<K> ids) throws Exception ;
	/**
	 * 根据雇员编号查询指定的雇员信息
	 * @param id	要查询的雇员编号
	 * @return		如果雇员信息存在，则将数据以vo类对象的形式返回，否则返回null
	 * @throws Exception	SQL执行异常
	 */
	public V findById(K id) throws Exception ;
	/**
	 * 查询指定数据表的全部信息，并且以集合的形式返回
	 * @return	如果表中有数据，则数据封装为VO对象而后利用List集合返回，否则，集合的长度为0（size==0，而不是null）
	 * @throws Exception	SQL执行异常
	 */
	public List<V> findAll() throws Exception ;
	/**
	 * 分页进行数据的模糊查询，查询的结果以集合的形式返回
	 * @param currentPage	当前所在的页
	 * @param lineSize		每页要显示的数据行数
	 * @param column		要进行模糊查询的数据列
	 * @param keyword		模糊查询的关键字
	 * @return				
	 * @throws Exception	SQL执行异常
	 */
	public List<V> findAllSplit(Integer currentPage , Integer lineSize , String column , String keyword)throws Exception ;
	/**
	 * 进行模糊查询数据量的统计，如果表中没有记录统计的结果就是0
	 * @param column		要进行模糊查询的数据列
	 * @param keyword		模糊查询的关键字 
	 * @return
	 * @throws Exception
	 */
	public Integer getAllCount(String column , String keyword) throws  Exception ;
}
