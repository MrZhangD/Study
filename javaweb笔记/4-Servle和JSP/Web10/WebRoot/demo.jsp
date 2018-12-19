<%@ page language="java" import="java.util.*,bean.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!-- 导入了jsp标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>演示jstl核心标签(if 和 choose)</title>
  </head>
  <body>
	<%
		User user1 = new User();
		user1.setName("张迪");
		user1.setSex("m");
		user1.setAge(22);
		request.setAttribute("user", user1);
	 %>
	 <h1>
	 	${user.name}<br>
	 	${user.sex}<br>
	 	${user.age}<br>
	 	姓名：<c:if test="${user.name == '张迪'}">没错，他叫张迪</c:if><br>
	 	<!-- var="flag" scope="request"  在这个标签里表示的是，request.setAttribute("flag","el表达式的值")
	 	向隐含对象天绑定了一个数据，scope="session"...等都可以	
	 	-->
	 	性别：<c:if test="${user.sex == 'm'}" var="flag" scope="request">大男子汉！！</c:if>
	 		<c:if test="${!flag}">萌妹子！</c:if><br>
		年龄：
		<c:choose>
			<c:when test="${user.age < 18}">哇偶，未成年，小朋友</c:when>
			<c:when test="${user.age >=18 && user.age <=28 }">成年之后，正值青春！！</c:when>
			<c:when test="${user.age >28 && user.age <=50}">迈向中年</c:when>
			<c:otherwise>老了老了。。。</c:otherwise>
		</c:choose>	 	
	 </h1>
  </body>
</html>
