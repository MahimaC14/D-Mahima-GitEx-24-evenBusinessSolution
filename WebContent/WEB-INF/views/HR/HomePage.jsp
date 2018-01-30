<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3 align="center">Status : ${sessionScope.status}</h3>
<a href="hr/hr_add">Add Employees</a>
<a href="hr/deleteEmployee">Delete Employee</a>
<a href="hr/getEmployeeUpdated">Update Employee</a>
<a href="<spring:url value='ChangePassword2'/>">Change password</a>
<a href="hr/getFullEmployeeByID">Employee Full Details</a>
<a href="hr/listAllEmployee">All Employee</a>
 <table border="1">
 <tr><td>ID   :</td><td>${sessionScope.empdata.id}</td></tr>
 <tr><td> Name :</td><td>${sessionScope.empdata.name}</td></tr>
 <tr><td>Email: </td><td> ${sessionScope.empdata.email}</td></tr>
 <tr><td> Role : </td><td> ${sessionScope.empdata.role}</td></tr>
 <tr><td> Registration Date:  </td><td> ${sessionScope.empdata.regDate} </td></tr>
 </table>
 <h4><a href="<spring:url value='/Employee/logout'/>">Log Out</a></h4>
</body>