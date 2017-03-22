<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.test.bean.Subject" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN QUESTION INSERT</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="<c:url value='/static/css/style1.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/javascript/homepage.js' />" type="text/javascript"></link>
    
</head>
<body style="background-color:CadetBlue"> 
<div class="form"> 
      <div class="tab-content">
<h1>Please enter the question :</h1>

</div>
 <div>
<form:form action="./QuestionController" commandName="subject">
   
  	<h3>You requested to insert a question for the subject: ${modelSubject.subject}</h3> 
 	<br>
<input type="hidden" name="questionId" value="0">
 Subject ID<input type="text" name="subjectId" value=" ${modelSubject.subjectId}" "fixed value" readonly ><br><br>
 Question<input type="text" name="question"><br><br>
 Option 1 <input type="text" name="op1"><br><br>
 Option 2 <input type="text" name="op2"><br><br>
 Option 3 <input type="text" name="op3" ><br><br>
 Option 4 <input type="text" name="op4"><br><br>
 Answer <input type="number" name="answer"><br>
 </div>
 <br>
 <input type="submit" value="submit" name="insert">

 </form:form>
 <br><br>
 <form:form action="./AdminHomePage" method="post">
 <input type="submit" class="button-block" value="Back">
 </form:form>
</div>
</body>
</html>