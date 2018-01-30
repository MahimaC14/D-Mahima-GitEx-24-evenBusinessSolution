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

	<form:form modelAttribute="employee" method="post">
		<table>

			<tr>
				<td>Enter old password</td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter new Password</td>
				<td><form:password path="nPassword" /></td>
				<td><form:errors path="nPassword" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter confirm Password</td>
				<td><form:password path="cPassword" /></td>
				<td><form:errors path="cPassword" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Change Password" /></td>

			</tr>

		</table>
	</form:form>
</body>