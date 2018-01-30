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
	<h3 align="center">Close A/C</h3>
	<form:form modelAttribute="bankAccount" method="post">
		<table>

			<tr>
				<td>Enter Account ID</td>
				<td><form:input path="acctId" /></td>
				<td><form:errors path="acctId" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter PIN</td>
				<td><form:password path="pin" /></td>
				<td><form:errors path="pin" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Close A/C" /></td>

			</tr>

		</table>
	</form:form>
</body>