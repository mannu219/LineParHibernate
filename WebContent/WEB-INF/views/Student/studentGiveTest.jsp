<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.bean.Subject"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=radio] {
	height: auto;
	width: auto;
	display: inline;
}
</style>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GIVE TEST</title>
<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" />"></script>
<link href="<c:url value='/static/css/style1.css' />" rel="stylesheet"></link>
 
<script>
	$(document).ready(function() {
		$("#giveTest").addClass("active");
	});
</script>
</head>
<body>
	 
	<%
		ArrayList<Subject> subList = (ArrayList<Subject>) request.getAttribute("subjectDisplay");
	%>
	<div class="form">
		<div class="tab-group">
			<form action="${pageContext.request.contextPath}/TestController"
				method="post">

				<div style="color: white;">
					<table border="1" style="width: 100%;">
						<tr>
							<th>Subject Id</th>
							<th>Subject Name</th>
							<th>Examination Start Date</th>
							<th>Examination End Date</th>
							<th>Select</th>
						</tr>
						 
					 <c:forEach var="element" items="${subjectDisplay}">
				 	<tr>
							<td>${element.subjectId} </td>
							<td> ${element.subject} </td>
							<td> ${element.start} </td>
							<td>${element.end}  </td>
							<td><input type="radio"  value="${element.subjectId}  "></td>
					</tr>
					 </c:forEach>
					</table>
				</div>
				<br> <input type="submit" class="button button-block"
					name="giveTest">
			</form>
		</div>
		<form action="${pageContext.request.contextPath}/Student/student.jsp"
			method="post">
			<input type="submit" class="button-block" value="Back">
		</form>
	</div>
</body>
</html>