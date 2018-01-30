<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<h3>Last Action Status : ${requestScope.status}</h3>
	<h3 align="center">Employee List</h3>
	<table>
		 <c:forEach var="hr" items="${requestScope.hr_list}">
			<tr>
				<td>${hr.employee_id}</td>
				<td>${hr.first_name}</td>
				<td>${hr.last_name}</td>
				<td>${hr.email}</td>
				<td><fmt:formatDate value="${hr.hire_date}" pattern="dd-MM-yyyy" /></td>
				<td>${hr.salary}</td>
						
			</tr>
		</c:forEach>
	</table>
	<h3 align="center">
		<a href="register">Add Customer</a>
	</h3>

</body>
</table>
</body>
</html>