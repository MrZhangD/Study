<%@page import="java.util.*,java.text.*"  %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<title>Hello,JSP</title>
	</head>
	<body style="font-size: 30px;">
		<%
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		 %>
			今天时间:<%=sdf.format(date) %>
		 <br>
			中文测试中文测试中文测试中文测试中文测试
		 <br>
		<%
			for(int i = 0 ; i < 50 ; i++){
				out.println("hello,Jsp!<br>");
			}
		 %>
	</body>
</html>