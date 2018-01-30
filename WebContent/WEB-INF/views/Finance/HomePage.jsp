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
<h4 align="center"><a href="<spring:url value='/acct/summary'/>">Show Bank Account Summary</a></h4>
<h4 align="center"><a href="<spring:url value='/acct/create'/>">Create Bank Account</a></h4>
<h4 align="center"><a href="<spring:url value='/acct/update'/>">Update Bank Account</a></h4>
<h4 align="center"><a href="<spring:url value='/acct/close'/>">Close Bank Account</a></h4>

<h4><a href="<spring:url value='/Employee/logout'/>">Log Out</a></h4>
</body>