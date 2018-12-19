<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>测试el表达式读取请求参数</title>
  </head>
  <body>
  	<!-- http://localhost:8080/Web09/a8.jsp?username=zhangdi&city=c1&city=c3 -->
	<h1><%="${param.username}=" %>${param.username}</h1>
	<h1><%="${paramValues.city[1]}=" %>${paramValues.city[1]}</h1>
  </body>
</html>
