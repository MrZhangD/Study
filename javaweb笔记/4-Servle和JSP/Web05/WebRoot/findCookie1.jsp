<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>findCookie1</title>
  </head>
  <body>
  	<%
  		Cookie[] cookies = request.getCookies();
  		for(int i = 0 ; i < cookies.length ; i++){
  			out.print("<h1>cookie" + i + "'s name:" + cookies[i].getName() + "----------");
			out.println("cookie" + i + "'s value:" + URLDecoder.decode(cookies[i].getValue(), "utf-8") + "</h1>");
  			
  		}
  	 %>
  </body>
</html>
