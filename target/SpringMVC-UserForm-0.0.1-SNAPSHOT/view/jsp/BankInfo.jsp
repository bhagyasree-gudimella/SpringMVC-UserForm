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
<title>Bank Info Page</title>
</head>
<body>
	<h2>Bank Info Page</h2>
	<hr>
	<br>
	<form:form name="bankInfoForm" modelAttribute="user" method="post">
		<table width=100% cellpadding="6">
			<tr>
				<th>Bank Name</th>
				<td><form:input path="bank_name" type="text" required="required"/></td>
			</tr>
			
			<tr>
				<th>Account Details</th>
				<td><form:input path="account_details" type="text" required="required"/></td>
			</tr>
			
			<tr>
				<th>SSN</th>
				<td><form:input path="ssn_number" type="text" placeholder="xxx-xx-xxxx"/></td>
			</tr>
		</table>
			
		<br><br>	
		<input type="submit" name="submit_button" value="SUBMIT" class="submit_button" />
	</form:form>
</body>
</html>