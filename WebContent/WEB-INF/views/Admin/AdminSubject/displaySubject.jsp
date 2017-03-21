<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN SUBJECT DISPLAY</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.3/jspdf.debug.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="<c:url value='/static/css/style1.css' />" rel="stylesheet"></link>
<script src="<c:url value='/static/javascript/pdf.js' />" type="text/javascript"></script>
</head>
<body>
 
	<div class="form">
	<h1>Subject Details : </h1>
		<div class="tab-group">

			<div id="content" style="color: black;">
				<table border="1" style="width: 100%;">
					<tr>
						<th>Subject Id</th>
						<th>Subject Name</th>
						<th>Examination Start Date</th>
						<th>Examination End Date</th>

					</tr>
					<c:forEach var="element" items="${subjectDisplay}">
					<tr>
						<td> ${element.subjectId}</td>
						<td> ${element.subject}</td>
						<td> ${element.start}</td>
						<td> ${element.end}</td>

					</tr>
					</c:forEach>
				</table>
			</div>
			<br>
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