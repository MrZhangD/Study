<%@page import="java.util.*,vo.Emp,javax.servlet.*" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<title>list1</title>
	<style type="text/css">
		table{
			border: solid 2px #ccc;
			border-spacing: 0px;
			width: 40%;
		}
		td,th{
			border: solid 2px #ccc;
		}
		.row1{
			background-color:#7AC5CD;
		}
		.row2{
			background-color:#FAF0E6;
		}
	</style>
	<script type="text/javascript">
		function del(name){
			return confirm("确认删除" + name + "么？");
		}
	</script>
</head>
<body>
	<table>
		<thead>
			<tr style="background-color: #FFFFE0;">
				<th>name</th>
				<th>salary</th>
				<th>age</th>
				<th>id</th>
				<th>功能区</th>
			</tr>
		</thead>
		<tbody>
			<% 
				//读取转发过来的资源
				List<Emp> emps = (List<Emp>)request.getAttribute("emps");
				for(int i = 0 ; i<emps.size() ; i++){
					Emp emp = emps.get(i);
					String name = emp.getName();
					Float salary = emp.getSalary();
					Integer age = emp.getAge();
					Integer id = emp.getId();
			%>
			<tr class="row<%=i%2+1 %>">
				<td><%=name %></td>
				<td><%=salary %></td>
				<td><%=age %></td>
				<td><%=id %></td>
				<td style="text-align: center;"><a href='del.do?id=<%=id %>' onclick="return del('<%=name %>')">删除</a>
				&nbsp;&nbsp;&nbsp;<a href='alter.do?id=<%=id %>'>修改</a>
				</td>
			</tr>
			<%
				}
			 %>
		</tbody>
	</table>
	<a href="emp.jsp"><input type="button" value="添加员工"></a>
</body>
</html>