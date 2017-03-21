<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.3/jspdf.debug.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="<c:url value='/static/css/style1.css' />" rel="stylesheet"></link>
<script src="<c:url value='/static/javascript/homepage.js' />" type="text/javascript"></script>
<title>ADMIN STUDENT DISPLAY</title>
</head>
<body>
	 
	 
	<div class="form">
		<div class="tab-group">
				<div id="content" style="color: black;">
				<h1> Student Details : </h1>
					<table border="1" style="width: 100%;">
				
						<tr>
							<th>Name</th>
							<th>Username</th>
							<th>Phone</th>
							<th>Email</th>
							<th>Password</th>
						</tr>
						<c:forEach var="element" items="${studentDisplay}">
						<tr>
							<td> ${element.name}</td>
							<td> ${element.username}</td>
							<td> ${element.phone}</td>
							<td> ${element.email}</td>
							<td> ${element.password}</td>
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