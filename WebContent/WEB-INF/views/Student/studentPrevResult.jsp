<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.test.bean.Result" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PREVIOUS RESULT</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.3/jspdf.debug.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="<c:url value='/static/css/style1.css' />" rel="stylesheet"></link>
<script src="<c:url value="/static/javascript/pdf.js" />"></script>
 
    <script>
$(document).ready(function() {
        $("#prevResult").addClass("active");
});
</script>
<style>
.form{
text-align: center;
}
</style>
</head>
<body style="background-color:CadetBlue">

<div class="form">
<form:form action="./StudentBackFromPrevResult" method="post">
<div class="tab-group">
 <div style="color: black;" id="content">
 <h1>Username : ${username} </h1>
 <h1>Previous Results</h1>
 <input type="hidden" name="username" value="${username}">
	<table border="1" style="width:100%;">
	<tr>
	<th>Username</th>
	<th>Subject Id</th>
	<th>Result(in %)</th>
	<th>Date</th>
	</tr>
	<c:forEach var="element" items="${testResult}">
		<tr>
			<td> ${element.username} </td>
			<td> ${element.subject} </td>		
			<td> ${element.result} </td>
			<td> ${element.date} </td>
		</tr>
	 
	</c:forEach>
</table>
 </div><br>
</div>
 <br>
 <input type="button" onclick="javascript:demoFromHTML();" class="button-block" id="pdf" value="Save As Pdf"><br><br>
 
			<input type="submit" class="button-block" value="Back">
		</form:form>
</div>
</body>
</html>