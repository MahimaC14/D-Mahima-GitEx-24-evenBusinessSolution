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
	<form:form modelAttribute="address" method="post">
		<table align="center">
			<tr>
				<td>City</td>
				<td><form:input path="city" /></td>
				<td><form:errors path="city" cssClass="error" /></td>
			</tr>
			<tr>
				<td>State</td>
				<td><form:input path="state" /></td>
				<td><form:errors path="state" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><form:input path="country" /></td>
				<td><form:errors path="country" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Contact Type</td>
				<td><form:input path="myPhone.type" /></td>
				<td><form:errors path="myPhone.type" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><form:input path="myPhone.number" /></td>
				<td><form:errors path="myPhone.number" cssClass="error" /></td>
			</tr>
			<tr>
				<td align="right" colspan="2"><input type="submit"
					value="Reg Me" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>