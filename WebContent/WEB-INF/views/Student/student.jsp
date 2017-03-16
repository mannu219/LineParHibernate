<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>STUDENT HOME PAGE</title>
 <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" />"></script>
<link href="<c:url value='/static/css/style1.css' />" rel="stylesheet"></link>
 <script src="<c:url value="/static/javascript/homepage.js" />"></script>
<script>
var audio = new Audio('../heartbeat.mp3');
audio.play();
</script>
<%
	if (session.getAttribute("giveTestSession") != null) {
		out.println(session.getAttribute("giveTestSession"));
		session.setAttribute("forceSubmit", "force");
		response.sendRedirect("./Test/giveTest.jsp");
	}
%>
</head>
<body>
	 
	<%@include file="./studentHeader.jsp"%>
	<%@include file="../Test/logout.jsp"%>  
</body>
</html>