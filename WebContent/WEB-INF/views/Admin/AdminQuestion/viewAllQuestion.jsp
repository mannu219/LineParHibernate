<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.bean.Question"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN QUESTION DISPLAY</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.3/jspdf.debug.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="<c:url value='/static/css/style1.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/javascript/pdf.js' />" type="text/javascript"></link>
<script>
	$(document).ready(function() {
		$("#giveTest").addClass("active");
	});
</script>
</head>
<body>
	
	<div class="form">
		<div class="tab-group">
			<div id="content" style="color: black;">
				<h2> Subject ID:${modelSubject.subjectId} </h2>
				<h2> Subject   :${modelSubject.subject} </h2>
				<table border="1" style="width: 100%;">
					<tr>
						<th>Question Id</th>
						<th>Question</th>
						<th>Answer</th>
					</tr>
					<c:forEach var="element" items="${sessionQuestionAll}">
					<tr>
						<td>${element.questionId} </td>
						<td> ${element.question} </td>
						<td> ${element.ans} </td>
					</tr>
					  </c:forEach>
				</table>
			</div>
		</div>

		<br> <input type="button" onclick="printDiv('content');"
			class="button-block" id="pdf" value="Print Content"><br>
		<br>
		<form:form action="./AdminHomePage" method="post">
 <input type="submit" class="button-block" value="Back">
 </form:form>
	</div>
</body>
</html>