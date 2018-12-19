<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>测试el表达式的一些简单的运算</title>
  </head>
  <body>
  	<h1>el表达式进行算术运算</h1>
		<h3>&nbsp;&nbsp;&nbsp;<%="${1+1}="%>${1+1}
			&nbsp;&nbsp;&nbsp;<%="${10-4}="%>${10-4}
			&nbsp;&nbsp;&nbsp;<%="${3*8}="%>${3*8}
			&nbsp;&nbsp;&nbsp;<%="${9/3}="%>${9/3}
			&nbsp;&nbsp;&nbsp;<%="${10%4}="%>${10%4}
			<% request.setAttribute("a", 12); %>
			<% request.setAttribute("b", 10); %><br>
			&nbsp;&nbsp;&nbsp;<%="${a+b}="%>${a+b}：
			a和b是隐含对象绑定的数据。
		</h3>
	<h1>el表达式进行关系运算</h1>
		<h3>
			&nbsp;&nbsp;&nbsp;<%="${10>12}="%>${10>12}
			&nbsp;&nbsp;&nbsp;<%="${10>=10}="%>${10>=10}
			&nbsp;&nbsp;&nbsp;<%="${'a'=='b'}="%>${"a"=="b"}
			&nbsp;&nbsp;&nbsp;<%="${10!=8}="%>${10!=8}
			<%request.setAttribute("str","zhangdi"); %><br>
			&nbsp;&nbsp;&nbsp;<%="${'zhangdi' == str}="%>${"zhangdi" == str}：
			str是隐含对象绑定的数据。
		</h3>
	<h1>el表达式进行逻辑运算</h1>
		<h3>
			&nbsp;&nbsp;&nbsp;<%="${true||false}=" %>${true||false}
			&nbsp;&nbsp;&nbsp;<%="${2>1&&3>5}=" %>${2>1&&3>5}
		</h3>
	<h1>el表达式进行empty运算</h1>
		<h3>
			<%
				List list1 = new ArrayList();
				list1.add(22);
				request.setAttribute("list",list1);
			%>
			&nbsp;&nbsp;&nbsp;<%="${empty list}=" %>${empty list}
			&nbsp;&nbsp;&nbsp;判断集合是否为空，list是隐含对象绑定的数据<br>
			 <%
			 	String str1 = "";
			 	request.setAttribute("str1", str1);
			 %>
			&nbsp;&nbsp;&nbsp;<%="${empty str1}=" %>${empty str1}
			&nbsp;&nbsp;&nbsp;判断是否是空字符串，str1是隐含对象绑定的数据<br>
			&nbsp;&nbsp;&nbsp;<%="${empty null}=" %>${empty null}&nbsp;&nbsp;&nbsp;null(空值也是true)
		</h3>
  </body>
</html>
