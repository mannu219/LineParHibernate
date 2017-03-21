<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/static/css/style1.css' />" rel="stylesheet"></link>
<title>ADMIN STUDENT SEARCH</title>
</head>
<body>
 
 
<div class="form">
<div class="tab-group">
<h1>List Of Students :</h1>
 <form action="./StudentControllerSearch">

 	<div style="color: black;">
	<table border="1" style="width:800;">
	<tr>
	<th > Username </th>

	</tr>
	<c:forEach var="element" items="${studentDisplay}">
		<tr>
			<td> ${element.username}</td>
		</tr>
	 </c:forEach>
	</table>
 	</div><br>
 	<h1> Search User :</h1>
 	<input type="text" name="username" ><br><br>
 	<input type="submit"  value="Search" name="search">
</form>
</div>
<br>
<form:form action="./AdminHomePage" method="post">
 <input type="submit" class="button-block" value="Back">
 </form:form>
</div>
</body>
</html>