<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登陆成功</title>
  </head>
  <%
  	//session是隐含对象
  	Object obj = session.getAttribute("user");
  	if(obj == null){
  		response.sendRedirect("login.jsp");
  	}
   %>
  <body style="font-size: 30px;">
   登陆成功<br>
  </body>
  <%
  	System.out.print("他还是执行了");
   %>
</html>
