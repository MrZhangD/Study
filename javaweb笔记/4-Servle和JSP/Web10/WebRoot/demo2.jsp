<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="test" prefix="c1"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>演示jstl的自定义标签</title>
  </head>
  <body style="font-size: 30px;">
		<c1:hello num="${5}" msg="演示jstl的自定义标签"/>
		Date:<c1:date pattern="yyyy-MM-dd HH:mm:ss"/>
  </body>
</html>
