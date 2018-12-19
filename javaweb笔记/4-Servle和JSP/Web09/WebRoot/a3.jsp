<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>测试jsp中的隐含对象pageContext</title>
  </head>
  <body>
  	<%
  		pageContext.setAttribute("username", "张迪");
  		HttpSession session1 = pageContext.getSession();
  	 %>
  	 <h1>
  	 	pageContext<br>
  	 	username: <%=pageContext.getAttribute("username") %><br>
  	 	session1Id: <%=session1.getId() %>
  	 </h1>
  </body>
</html>
