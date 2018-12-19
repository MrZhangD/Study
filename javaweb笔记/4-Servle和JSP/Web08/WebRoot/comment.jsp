<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>评论交由过滤器</title>
  </head>
  <body>
	<form action="process" method="post">
		评论：<br>
		<textarea  rows="5" cols="30" name="content" style="resize:none"  autocomplete="off"></textarea><br>
		<input type="submit" value="发表">
	</form>
  </body>
</html>
