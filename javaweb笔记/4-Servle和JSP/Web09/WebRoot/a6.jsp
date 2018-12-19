<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import="vo.*"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>测试el表达式访问bean的属性</title>
  </head>
  <body>
  	<%
  		User user = new User();
  		user.setName("张三");
  		user.setAge(22);
  		user.setSex("男");
  		user.setInterests(new String[]{"看书" , "运动" , "听歌"});
  	  	session.setAttribute("user", user);
  	  	
  	  	User user1 = new User();
  	  	user1.setName("lili");
  	  	user1.setAge(20);
  	  	user1.setSex("女");
  	  	user1.setInterests(new String[]{"读书" , "旅游" , "跑步"});
  	  	request.setAttribute("user", user1);

  	%>
  	<h1>用户一(方式一----》<%="${user.name}"%>)</h1>
	<h1>姓名：${sessionScope.user.name}</h1>
	<h1>年龄：${sessionScope.user.age}</h1>
	<h1>性别：${sessionScope.user.sex}</h1>
	<h1>爱好：${sessionScope.user.interests[0]},${sessionScope.user.interests[1]},${sessionScope.user.interests[2]}</h1>
	
	<h1>用户二(方式二----》<%="${user[\"name\"]}"%>)</h1>
	<h1>姓名：${user["name"]}</h1>
	<h1>年龄：${user["age"]}</h1>
	<h1>性别：${user["sex"]}</h1>
	<h1>爱好：${user.interests[0]},${user.interests[1]},${user.interests[2]}</h1>
  </body>
</html>
