package pers.zhangdi.vo;

import java.io.Serializable;

//Dept部门表（vo类）:deptno , dname , loc	:一定要记住简单java类最好实现Serializable接口

@SuppressWarnings("serial")
public class Dept implements Serializable {
	private Integer Deptno ;
	private String dname ;
	private String loc ;
	public Integer getDeptno() {
		return Deptno;
	}
	public void setDeptno(Integer deptno) {
		Deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
