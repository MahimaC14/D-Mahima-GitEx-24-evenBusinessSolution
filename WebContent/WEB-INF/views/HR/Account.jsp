<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE>
<html>
<head>
<%-- <link href="<spring:url value='/css/layout.css'/>" type="text/css"
	rel="stylesheet"> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3 align="center">Address Page</h3>
	<form:form modelAttribute="accounts" method="post">
		<table align="center">
			<tr>
				<td>Amount</td>
				<td><form:input path="Amount" /></td>
				<td><form:errors path="Amount" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Bank Name</td>
				<td><form:input path="bankName" /></td>
				<td><form:errors path="bankName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Type</td>
				<td><form:input path="type" /></td>
				<td><form:errors path="type" cssClass="error" /></td>
			</tr>
			<tr>
				<td align="right" colspan="2"><input type="submit" value="Add Employee" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>