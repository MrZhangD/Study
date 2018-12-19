<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>pageContext</title>
  </head>
  <body>
  	<%
  		pageContext.setAttribute("area", "山东师范大学");
  	 %>
  	 <h1>
  	 	pageContext<br>
  	 	area: <%=pageContext.getAttribute("area") %>
  	 </h1>
  </body>
</html>
