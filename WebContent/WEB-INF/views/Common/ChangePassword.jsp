<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
<link href="<spring:url value='/css/style.css'/>" type="text/css"
	rel="stylesheet">
</head>
<body>
	<form:form method="post" action="changePassword">
		<table>

			<tr>
				<td>Old Password</td>
				<td><input type="text" name="oldPassword" /></td>
			</tr>

			<tr>
				<td>New Password</td>
				<td><input type="text" name="newPassword" /></td>
			</tr>
			
			<tr>
				<td>Confirm Password</td>
				<td><input type="text" name="confirmPassword" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Change Password" /></td>
			</tr>

		</table>
	</form:form>

</body>
</html>