<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@include file="/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	<%@ include file="/view/css/StyleSheet.css" %>
</style>
<title>Personal Info Page</title>
</head>
<body>
	<h2>Personal Info Page</h2>
	<hr>
	<br>
	
	<form:form name="personalInfoForm" modelAttribute="mUser" method="post">
	
		<table width=100% cellpadding="6">
			<tr>
				<th>First Name</th>
				<td><form:input path="first_name" type="text"/></td>
			</tr>
			
			<tr>
				<th>Middle Name</th>
				<td><form:input path="middle_name" type="text"/></td>
			</tr>
			
			<tr>
				<th>Last Name</th>
				<td><form:input path="last_name" type="text"/></td>
			</tr>
			
			<tr>
				<th>Email</th>
				<td><form:input path="email_address" type="text" placeholder="abc@domain.com"/></td>
			</tr>
			
			<tr>
				<th>Gender</th>
				<td>
					Male <form:radiobutton path="gender" value="male" required="required"/> 
					Female <form:radiobutton path="gender" value="female" required="required"/> 
				</td>
			</tr>
			
		</table>
		
		<br><br>
		<input type="submit" name="submit_button" value="SUBMIT" class="submit_button"> 
	
	</form:form>

</body>
</html>