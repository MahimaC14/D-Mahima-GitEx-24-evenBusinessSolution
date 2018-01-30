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
	<form:form modelAttribute="addEmployee" method="post"> <!-- object name -->
		<table>
			
			<tr>
				<td>Enter First Name</td>
				<td><form:input path="first_name" /></td>
				<td><form:errors path="first_name" cssClass="error"/></td>
			</tr>
			
			
			<tr>
				<td>Enter Last Name</td>
				<td><form:input path="last_name" /></td>
				<td><form:errors path="last_name" cssClass="error"/></td>
			</tr>
	
			
			<tr>
				<td>Enter Email</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td>Enter Phone Number</td>
				<td><form:input path="phone_number"/></td>
				<td><form:errors path="phone_number" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td>Enter Hire Date(dd-mm-yr)</td>
				<td><form:input path="hire_date" /></td>
				<td><form:errors path="hire_date" cssClass="error"/></td>
			</tr>
			
				<tr>
				<td>Enter salary</td>
				<td><form:input path="salary" /></td>
				<td><form:errors path="salary" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td>Enter Department id</td>
				<td><form:input path="drpt.department_id" /></td>
				<td><form:errors path="drpt.department_id" cssClass="error"/></td>
			</tr>
			
			
			<%-- <tr>
				<td>Enter account</td>
				<td><form:input path="acc.AccID"/></td>
				<td><form:errors path="acc.AccID" cssClass="error"/></td>
			</tr> --%>
			
	
			<tr>
				<td>Enter job</td>
				<td><form:input path="job.job_id"/></td>
				<td><form:errors path="job.job_id" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td>Enter location</td>
				<td><form:input path="loc.location_id"/></td>
				<td><form:errors path="loc.location_id" cssClass="error"/></td>
			</tr>
 			<tr>
				<td><input type="submit" value="Next" /></td>

			</tr>
 
		</table>
	</form:form>
</body>