<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
	<title>emp</title>
	<meta charset="UTF-8">
	<style type="text/css">
		body{
			font-size: 30px;
		}
	</style>
</head>
<body>
	<form action="add.do" method="post">
		<p>姓名:<input type="text" name="name"></p>
		<p>薪水:<input type="text" name="salary"></p>
		<p>年龄:<input type="text" name="age"></p>
		<input type="submit" value="确认添加" onclick="return confirm('确认添加么?');">
	</form>
	<a href="list.do"><input type="submit" value="查询全部" ></a>
</body>
</html>