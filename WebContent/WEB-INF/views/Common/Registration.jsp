<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <link href="<spring:url value='/css/layout.css'/>" type="text/css"
	rel="stylesheet">
 --%>
</head>
<body>
	<h3 align="center">Register Here</h3>
	<form:form modelAttribute="employee" method="post">
		<table align="center">
			<tr>
				<td>Enter Email</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Enter Name</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Enter Role</td>
				<td>
					<%-- <form:input path="role" /> --%> 
					<form:select path="role">
						<form:option value="" label="-----Select-----" />
						<form:options items="${roles}" />
					</form:select>
				</td>
				<td><form:errors path="role" cssClass="error" /></td>
			</tr>
			<tr>
				<!-- <td>Enter Reg Date</td> -->
				<td><form:hidden path="regDate" value="${today}"/></td>
				<td><form:errors path="regDate" cssClass="error" /></td>
			</tr>
			<tr>
				<td align="right" colspan="2"><input type="submit" value="Next" /></td>
			</tr>

		</table>
	</form:form>

</body>
</html>