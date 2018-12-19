<%@page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>测试page指令的errorPage属性</title>
  </head>
  <body>
	<%
		String str = "123a";
		int i = Integer.parseInt(str);
	 %>
  </body>
</html>
