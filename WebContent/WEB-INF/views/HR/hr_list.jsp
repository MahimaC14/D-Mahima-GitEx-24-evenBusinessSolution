<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>   
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HR page 1</title>
<link href="<spring:url value='/css/style.css'/>" type="text/css"
	rel="stylesheet">
</head>
<body>
Employee Added
	<h3>Last Action Status : ${requestScope.status}</h3>
	<h3 align="center">Employee List</h3>
	<table>
		<c:forEach var="empl" items="${requestScope.empl_list}">
			<tr>
			<td>${empl.first_name}</td>
				<td>${empl.email}</td>
				<td><fmt:formatDate value="${empl.hire_date}"
						pattern="dd-MM-yyyy" /></td>
						<td><a href="<spring:url value='update?id=${empl.employee_id}'/>">Update employee</a></td>
						<td><a href="<spring:url value='delete/${empl.employee_id}'/>">Un-subscribe employee</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
	
<!-- 	<h3 align="center">
		<a href="index">Add employee</a>
	</h3>
 -->
</body>