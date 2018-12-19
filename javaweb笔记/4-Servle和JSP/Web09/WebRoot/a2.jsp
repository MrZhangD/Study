<%@page import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
	<% 
		for(int i = 0 ; i < 20 ; i++){
			out.println("<h1 style='color:red;'>没错，我就是通过include指令的file属性导入a1页面的a2.jsp文件！</h1>");
		}
	%>
