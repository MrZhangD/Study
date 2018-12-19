<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录页</title>
  </head>
  <body>
	<form action="login" method="post">
		<fieldset style="text-align: center; width: 20%; margin: 0 auto;">
			<legend >登录</legend>
			账号：<input type="text" name="username"><br><br>
			密码：<input type="password" name="pwd"><br>
			<input type="submit" value="登录">
			<%
				String msg = (String)request.getAttribute("login_failed");
				if(msg == null)
					msg="";
			 %>
			 <span style="color: red;"><%=msg %></span>
		</fieldset>
	</form>
  </body>
</html>
