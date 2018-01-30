<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<spring:url value='/css/main.css'/>" type="text/css"
	rel="stylesheet">
</head>
<body>
<h3 align="center"> Create A/C</h3>
	<form:form modelAttribute="bankAccount" method="post">
		<table>

			<tr>
				<td>Enter Account Type</td>
				<td><form:input path="type" /></td>
				<td><form:errors path="type" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter Account Balance</td>
				<td><form:input path="balance" /></td>
				<td><form:errors path="balance" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter PIN</td>
				<td><form:password path="pin" /></td>
				<td><form:errors path="pin" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create A/C" /></td>

			</tr>

		</table>
	</form:form>
</body>