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
<title>ONLINE TEST</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="<c:url value='/static/css/style1.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/javascript/test.js' />"></link>
 
<style type="text/css">
body {
	color: black;
	font-size: 20px;
}

input[type=radio] {
	height: auto;
	width: auto;
	display: inline;
}
h1{
	text-align:center;
}
#timer_div {
	float: left;
}

.leftRight {
padding: 0px 400px 0px 300px;
	font-size: 50px;
}

a {
	padding: 0px 40px 0px 40px;
	float: left
}

.form {
	overflow: auto;
}
</style>
 
<script>
	$(document).ready(function() {
		$("#test").submit();
	});
</script>
 
</head>
<body style="background-color:CadetBlue">
<h1 >Online Test Start</h1>
<form:form action="./Result" method="post" commandName="question">   <!-- passing controll to TestResult.java controller -->
	 
		<div class="form">
		<c:set var="count" value="0" scope="page" />
		
			<c:forEach var="element" items="${Questions}" >
			<c:set var="count" value="${count + 1}" scope="page"/>
			
			<div class="question">
				<ol class="mySlides">
					<h3> QuestionNo: <c:out value="${count}"/> </h3>
					<h3> ${element.question} </h3>
					<li><input type="radio" name="${element.questionId}" value="${element.choice1}"> ${element.choice1} </li>
					<li><input type="radio" name="${element.questionId}" value="${element.choice2}"> ${element.choice2} </li>
					<li><input type="radio" name="${element.questionId}" value="${element.choice3}"> ${element.choice3} </li>
					<li><input type="radio" name="${element.questionId}" value="${element.choice4}"> ${element.choice4} </li>
					 
				</ol>
				<!--  		<div class="leftRight">
							<a class="left" id="lef" onclick="plusDivs(-1)">&#10094;</a>
							<div id="timer_div"></div>
 							<a class="right" id="rig" onclick="plusDivs(1)">&#10095;</a>
 							<br>
 							</div>
				 -->
			</div>
			</c:forEach>
			<!-- <div class="leftRight">
				<div class="arrow bounce">
					<a class="fa fa-arrow-down fa-2x" onclick="plusDivs(-1)">&#10094;prev</a>
				</div>
				<div id="timer_div"></div>
				<div class="arrow bounce1">
					<a class="fa fa-arrow-down fa-2x" onclick="plusDivs(1)">next&#10095;</a>
				</div>
				<br>
			</div>
			<br>
			<div id="dis">
				<h1>Please Answer Atleast One Question</h1>
			</div>
		</div> -->

		<br> 
		<div style="text-align:center;">
   			 <input type="submit" class="button button-block" id="subjectId" value="Finish Test">
		</div> 
	</form:form>

</body>
</html>