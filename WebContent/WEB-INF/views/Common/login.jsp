<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="<spring:url value='/css/main.css'/>" type="text/css"
	rel="stylesheet">
</head>
<body>
<h3> ${requestScope.status}</h3>
	<form:form id="login-form" modelAttribute="employee" method="post">
		<table>

			<tr>
				<td>Enter EmailID</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Select Role</td>
				<td>
					<form:select path="role">
						<form:option value="" label="----Select----"/>
							<form:options items="${roles}" />
					</form:select>
				</td>
				<td>
					<form:errors path="role" cssClass="error"/>
				</td>
	
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>

			</tr>

		</table>
	</form:form>
</body>