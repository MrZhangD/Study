<%@ page language="java" import="java.util.*,bean.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>演示jstl核心标签(forEach)</title>
	<style type="text/css">
		table{
			width: 60%;
			border: solid 2px #ccc;
			border-spacing: 0;
		}
		td{
			border: solid 2px #ccc;
		}
		.row{
			background-color: #8B7B8B;
		}
		.row1{
			background-color:  	#8DB6CD;
		}
		.row2{
			background-color:  #90EE90;
		}
	</style>
  </head>
  <body style="font-size: 30px;">
  	 <table>
  	 	<tr class="row">
  	 		<td>姓名</td>
  	 		<td>性别</td>
  	 		<td>年龄</td>
  	 		<td>index</td>
  	 		<td>count</td>
  	 	</tr>
	  	 <c:forEach items="${users}" var="us" varStatus="s">
			<tr class="row${s.index%2 + 1}">
	  	 		<td>${us.name}</td>
		 		<td>
		 			<c:if test="${us.sex == 'm'}" var="flag" scope="request">大男子汉！！</c:if>
		 			<c:if test="${!flag}">萌妹子！</c:if>
				</td>
				<td>
					<c:choose>
						<c:when test="${us.age < 18}">哇偶，未成年，小朋友</c:when>
						<c:when test="${us.age >=18 && us.age <=28 }">成年之后，正值青春！！</c:when>
						<c:when test="${us.age >28 && us.age <=50}">迈向中年</c:when>
						<c:otherwise>老了老了。。。</c:otherwise>
					</c:choose>
				</td>	
				<td>${s.index}</td>
				<td>${s.count}</td>
			</tr>
	  	 </c:forEach>
  	 </table>
  </body>
</html>
