package vo;

import java.io.Serializable;

//一定要记住简单java类最好实现Serializable接口
/**
 * @author MR.zhang
 * @param	表中的数据
 *	String name ;
 *	Float salary ;
 *	Integer age ;
 *	Integer id
 */
public class Emp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name ;
	private Float salary;
	private Integer age;
	private Integer id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
