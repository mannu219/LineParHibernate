 <%@page import="java.util.ArrayList"%>
    <%@page import="com.test.bean.Subject" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN SUBJECT SEARCH</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
 
  <link href="<c:url value='/static/css/style1.css' />" rel="stylesheet"></link>
   <link href="<c:url value='/static/css/admin.css' />" rel="stylesheet"></link>
 <script src="<c:url value='/static/javascript/homepage.js' /> "></script>
</head>
<body style="background-color:CadetBlue">
<div class="form">
	<div class="tab-group">
 		<h1>Subjects :</h1>
 		<div style="color: black;">
			<table border="1" style="width:800;">
			<tr>
			<th>Subject Id</th>
			<th>Subject Name</th>
 
			</tr>
			 
			<c:forEach var="element" items="${subjectDisplay}">
			<tr>
			<td> ${element.subjectId}</td>
			<td> ${element.subject}</td>
			</tr>
			</c:forEach>
			</table>
 		</div><br>
 	 </div><br>
 	 <form:form action="./SubjectControllerSearch">
 	<h1> Search Subject ID :</h1> 
 	<input type="number" min="1" name="subjectId" ><br><br>
 	<input type="submit"  value="search" name="search">
 	</form:form><br>
 	<form:form action="./AdminHomePage" method="post">
 		<input type="submit" class="button-block" value="Back">
 	</form:form>
</div>
 
</body>
</html>