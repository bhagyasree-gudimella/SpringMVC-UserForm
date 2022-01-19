<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	<%@ include file="/view//css/StyleSheet.css" %>
</style>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<h2>Error Page</h2>
	<hr>
	<br>
	<form name="errorPage">
		<p>${result}</p>
	</form>
</body>
</html>