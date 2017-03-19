<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="com.test.bean.Question" %>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN QUESTION UPDATE</title>
<% Question question=(Question)request.getAttribute("sessionQuestion"); %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style1.css"/>
</head>
<body>
<div class="form"> 
      <div class="tab-content">
<h1>Please enter the question</h1>

</div>
 <br>
 <div>
  <form:form action="./QuestionController" commandName="subject">
 
  You requested to Update Question Id : ${modelQuestion.questionId} 
 <br>
<input type="hidden" name="questionId" value="${modelQuestion.questionId}">
 Subject ID<input type="text" name="subject" value="${modelQuestion.subjectId}" >
 Question<input type="text" name="question" value="${modelQuestion.question}"><br>
 Option 1 <input type="text" name="op1" value="${modelQuestion.choice1}">
 Option 2 <input type="text" name="op2" value="${modelQuestion.choice2}">
 Option 3 <input type="text" name="op3" value="${modelQuestion.choice3}">
 Option 4 <input type="text" name="op4" value="${modelQuestion.choice4}">
 <br>
 Answer <input type="number" name="answer" value="${modelQuestion.answer}">
 </div>
 <br>
 <input type="submit" value="submit" name="update">
 </form:form>
<form:form action="./AdminHomePage" method="post">
 <input type="submit" class="button-block" value="Back">
 </form:form>
</div>
</body>
</html>