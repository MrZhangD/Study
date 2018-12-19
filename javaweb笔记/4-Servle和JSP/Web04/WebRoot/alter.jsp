<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import="vo.*" %>
<html>
<head>
	<title>修改信息</title>
</head>
<body>
	<%
		Emp emp = (Emp)request.getAttribute("emp");
	 %>
	<h1>姓名:<%=emp.getName()%>&nbsp;&nbsp;&nbsp;ID:<%=emp.getId() %></h1>
	<h1>信息修改</h1>
	<form action="modify.do" method="post">
		姓名：<input type="text" name="name" value="<%=emp.getName() %>"><br>
		薪水：<input type="text" name="salary" value="<%=emp.getSalary() %>"><br>
		年龄：<input type="text" name="age" value="<%=emp.getAge() %>"><br>
		<input type="text" name="id" value="<%=emp.getId()%>" hidden="hidden" >
		<input type="submit" value="确认修改" onclick="return confirm('确认修改？');">
	</form>
		<a href="list.do"><input type="button" value="返回列表"></a>
</body>
</html>
