<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.ArrayList"%>
    <%@page import="com.test.bean.Subject" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN SUBJECT SEARCH</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <link href="<c:url value='/static/css/admin.css' />" rel="stylesheet"></link>
 <script src="<c:url value='/static/javascript/homepage.js' /> "></script>
</head>
<body>
 
<div class="form">
	<div class="tab-group">
 	 
 		<div style="color: black;">
 		<h1>Subject Details :</h1>
		<table border="1" style="width:500;">
		<tr>
		<th>Subject Id</th>
		<th>Subject Name</th>
		<th>Start Date</th>
		<th>End Date</th>
		 
		</tr>
		 
					<tr>
						<td> ${subjectSearch.subjectId}</td>
						<td> ${subjectSearch.subject}</td>
						<td> ${subjectSearch.start}</td>
						<td> ${subjectSearch.end}</td>

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