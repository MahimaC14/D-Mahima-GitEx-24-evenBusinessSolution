<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<%-- ${requestScope.EmpFull}  --%>
<tr>
<td>Employee Id :${requestScope.employee.employee_id}</td>
 <td>Name :${requestScope.employee.first_name}${requestScope.employee.last_name}</td>
 <td>Email ID :${requestScope.employee.email}</td>
 <td>Phone NO :${requestScope.employee.phone_number}</td>
 <td>Hire Date :${requestScope.employee.hire_date}</td>
 <td>Salary :${requestScope.employee.salary}</td>
</tr>
 <tr>
 <td>Account Id :${requestScope.account.accID}</td>
<td>Balance :${requestScope.account.amount}</td> 
<td>Bank Name :${requestScope.account.bankName}</td>
<td>Type :${requestScope.account.type}</td>
</tr> 
<tr>
<td>Department Id :${requestScope.department.department_id}</td>
<td>Department Name :${requestScope.department.department_name}</td>
<td>Manager Id :${requestScope.department.manager_id}</td>
</tr>
<tr>
<td>Job Id :${requestScope.job.job_id}</td>
<td>Job Title :${requestScope.job.job_title}</td>
<td>Minimum Salary :${requestScope.job.min_salary}</td>
<td>Maximum Salary :${requestScope.job.max_salary}</td>
</tr>
<tr>
<td>Location Id :${requestScope.location.location_id}</td>
<td>Street Address :${requestScope.location.street_address}</td>
<td>Postal Code :${requestScope.location.postal_code}</td>
<td>City :${requestScope.location.city}</td>
<td>State Province :${requestScope.location.state_province}</td>
<td>Country :${requestScope.location.country_id}</td>
</tr>
</table>
</body>
</html>