<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@include file="/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	<%@ include file="/view/css/StyleSheet.css" %>
</style>
<meta charset="UTF-8">
<title>Delete User</title>
</head>
<body>
	<h2>Delete User</h2>
	<hr>
	<br>
	<form:form name="deleteUser" modelAttribute="email_address" method="post">
		Email 
		<form:input path="email_address" type="text"/> <br>
		
		<br><br>
		<input type="submit" name="submit_button" value="DELETE" class="submit_button" />
	</form:form>
</body>
</html>