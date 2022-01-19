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
<title>Ask via Email</title>
</head>
<body>
	<h2>Email Address</h2>
	<hr>
	<br>
	<form:form name="askForEmailForm" modelAttribute="email_address" method="post">
		Email 
		<form:input path="email_address" type="text"/> <br>
		
		<br><br>
		<input type="submit" name="submit_button" value="SUBMIT" class="submit_button" />
	</form:form>
</body>
</html>