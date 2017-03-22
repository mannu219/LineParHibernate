<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.bean.PrintResult"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.3/jspdf.debug.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="<c:url value='/static/css/style1.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/javascript/pdf.js' />" rel="stylesheet"></link>
<style>
#pdf {
	text-align: centre;
}
</style>
</head>
<body style="background-color:CadetBlue">
	<div class="form">
		<div class="tab-group">
				<h1>Test Completed</h1>
				<div id="content" style="color: white;">

					<h2> Username : ${modelUserName} </h2>
					<h1> Result : ${message1} </h1>
				</div>
				<br>
			 
		</div>
		<div id="editor"></div>
		<input type="button" onclick="javascript:demoFromHTML();"
			class="button-block" id="pdf" value="Save As Pdf"><br>
		<br>
		<form:form action="./StudentBack" method="post">
			<input type="submit" class="button-block" value="Back">
		</form:form>
	</div>
</body>
</html>