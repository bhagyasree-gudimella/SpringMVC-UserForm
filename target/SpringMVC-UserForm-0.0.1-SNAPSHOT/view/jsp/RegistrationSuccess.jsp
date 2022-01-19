<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.lavanya.gudimella.dto.User" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
     <%@include file="/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	<%@ include file="/view/css/StyleSheet.css" %>
</style>
<meta charset="UTF-8">
<title>Success Page</title>
</head>
<body>
	<h2>Registration Success</h2>
	<hr>
	<br>
	<%
		User user = (User) session.getAttribute("mUser");
			out.println("Hello, " + user.getFirst_name() + " " + user.getMiddle_name() + " " + user.getLast_name());
	%>
	
	<br><br>
	
	<jsp:useBean id="mUser" class="com.lavanya.gudimella.dto.User" scope="session"></jsp:useBean>
	
		<table border="1" cellpadding="15"> 
			<tr>
				<th>Personal Information</th>
				<th>Contact Information</th>
				<th>Bank Information</th>
			</tr>
			
			<tr>
				<td>
					First Name : <jsp:getProperty property="first_name" name="mUser"/>  <br>
					Middle Name : <jsp:getProperty property="middle_name" name="mUser"/>  <br>
					Last Name : <jsp:getProperty property="last_name" name="mUser"/>  <br>
					Email : <jsp:getProperty property="email_address" name="mUser"/>  <br>
					Gender : <jsp:getProperty property="gender" name="mUser"/>  <br>
				</td>
				
				<td>
					Address : <jsp:getProperty property="address" name="mUser"/>  <br>
					City : <jsp:getProperty property="city" name="mUser"/>  <br>
					State : <jsp:getProperty property="state" name="mUser"/>  <br>
					Country : <jsp:getProperty property="country" name="mUser"/>  <br>
					Contact : <jsp:getProperty property="phone_number" name="mUser"/>  <br>
					ZIPCODE : <jsp:getProperty property="zipcode" name="mUser"/>  <br>
				</td>
				
				<td>
					Bank Name : <jsp:getProperty property="bank_name" name="mUser"/>  <br>
					Account Details : <jsp:getProperty property="account_details" name="mUser"/>  <br>
					SSN : <jsp:getProperty property="ssn_number" name="mUser"/>  <br> 
				</td>
			</tr>
		</table>
	
</body>
</html>