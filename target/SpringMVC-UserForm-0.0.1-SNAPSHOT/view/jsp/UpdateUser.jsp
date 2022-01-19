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
<title>Update User</title>
</head>
<body>
	<h2>Update User</h2>
	<hr>
	<br>
	<form:form name="updateUserForm" modelAttribute="user" method="post">
		<table width=100% cellpadding="6">
			<tr>
				<th>Address</th>
				<td><form:input path="address" type="text" required="required"/></td>
			</tr>
			<tr>
				<th>City</th>
				<td><form:input path="city" type="text" required="required"/></td>
			</tr>
			<tr>
				<th>State</th>
				<td><form:input path="state" type="text" required="required"/></td>
			</tr>
			<tr>
				<th>Country</th>
				<td><form:input path="country" type="text" required="required"/></td>
			</tr>
			<tr>
				<th>ZIPCODE</th>
				<td><form:input path="zipcode" type="text" required="required"/></td>
			</tr>
			
			<tr>
				<th>Contact number</th>
				<td><form:input path="phone_number" type="text"/></td>
			</tr>
			
			<tr>
				<th>Bank Name</th>
				<td><form:input path="bank_name" type="text" required="required"/></td>
			</tr>
			
			<tr>
				<th>Account Details</th>
				<td><form:input path="account_details" type="text" required="required"/></td>
			</tr>
			
		</table>
	
		<br><br>
		<input type="submit" name="submit_button" value="UPDATE" class="submit_button" />
	</form:form>
</body>
</html>