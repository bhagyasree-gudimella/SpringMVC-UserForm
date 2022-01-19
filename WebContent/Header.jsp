<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	<%@ include file="/view/css/StyleSheet.css" %>
</style> 
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<h2>Welcome Page</h2>
	<hr>
	<br>
	<table cellpadding="8" width=50%>
		<tr>
			<th><a href="/SpringMVC-UserForm/Header.jsp">Home</a></th>
			<th><a href="/SpringMVC-UserForm/user/personalInfo/addPersonalInfo">Add User</a></th>
			<th><a href="/SpringMVC-UserForm/user/list/usersList">View Users List</a></th>
			<th><a href="/SpringMVC-UserForm/user/emailInfo/askForEmail">Update User</a></th>
			<th><a href="/SpringMVC-UserForm/user/deleteUser/delete">Delete User</a></th>
		</tr>
	</table>
</body>
</html>