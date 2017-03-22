<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList"%>
    <%@page import="com.test.bean.Student" %>
              <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN STUDENT SEARCH</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="<c:url value='/static/css/style1.css' />" rel="stylesheet"></link>
<script src="<c:url value='/static/javascript/homepage.js' />" type="text/javascript"></script>
</head>
<body style="background-color:CadetBlue">
 
<div class="form">
<div class="tab-group">
 
 <div style="color: black;">
 <h1>Student Details :</h1>
	<table border="1" style="width:900;">
	<tr>
	<th>Name</th>
	<th>Username</th>
	<th>Phone</th>
	<th>Email</th>
	<th>Password</th>
	</tr>
	 
	 
		<tr>
			<td> ${studentSearch.name}</td>
			<td> ${studentSearch.username}</td>
			<td> ${studentSearch.phone}</td>
			<td> ${studentSearch.email}</td>
			<td> ${studentSearch.password}</td>
		</tr>
	</table>
	</div>
	 
	</div><br>
	<form:form action="./AdminHomePage" method="post">
 <input type="submit" class="button-block" value="Back">
 </form:form>
	</div>
</body>
</html>