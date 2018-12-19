<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<html>
  <head>
    <title>测试监听器</title>
  </head>
  <body style="font-size:30px;" >
	这是首页，为了测试监听器！！<br>
	当前系统在线人数：
	<%=application.getAttribute("count") %>
	<br>
	<a href="logout">退出</a>
  </body>
</html>
