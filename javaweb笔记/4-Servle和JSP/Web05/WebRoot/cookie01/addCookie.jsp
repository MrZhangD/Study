<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>addCookie</title>
  </head>
  <body>
  	<%
  		Cookie c = new Cookie("name11",URLEncoder.encode("张迪","utf-8"));
  		response.addCookie(c);
  	 %>
  </body>
</html>
