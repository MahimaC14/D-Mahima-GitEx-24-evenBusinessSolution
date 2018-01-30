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
	 <form method="post"><%--  action="updateEmployee" --%>
		<table>
			
			 <tr>
				<td>Enter Employee ID</td>
				<td><input type="text" name="id"/></td>
				<td><form:errors path="employee_id" cssClass="error"/></td> 
			</tr>
			
		 	<tr>
				<td>
				<a href="updateEmployee"><input type="submit" value="Update Details"/></a>
				</td>
			</tr> 
 
		 </table>
	</form> 
	
</body>
</html>