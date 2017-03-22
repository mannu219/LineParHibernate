<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList"%>
    <%@page import="com.test.bean.Question" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN QUESTION DELETE</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="<c:url value='/static/css/style1.css' />" rel="stylesheet"></link>
<script type="text/javascript">
    $(document).ready(function(){
    	var $submit = $("#sub").hide();
    	var $submit1 = $("#dis").show();
    	var    $cbs = $("input[type='radio']").click(function() {
            $submit.toggle( $cbs.is(":checked") );
            $submit1.hide();
        });
       });
</script>
</head>
<body style="background-color:CadetBlue">
<div class="form"> 
      <div class="tab-content">
<h1>Select Questions To be Deleted</h1>
</div>
 <br>
<div class="form">
<div class="tab-group">

<form:form action="./QuestionController" commandName="subject">
 	<div style="color: black;">
	<table border="1" style="width:100%;">
	<tr>
	<th>Questions</th>
 
 
	</tr>
<c:forEach var="element" items="${sessionQuestionAll}">
		<tr>
		 
		<td> ${element.questionId }</td>
		<td> ${element.question }</td>
		<td><input type="radio" name="questionId" value="${element.questionId}  "></td>
		</tr>
	 
	</c:forEach>
	</table>
 	</div><br>
 	 <div id="dis">
 <h1>Please Select a question to delete</h1>
 </div>
 <input type="submit" id="questionId" value="Delete">
</form:form>
</div><br>
<form:form action="./AdminHomePage" method="post">
 <input type="submit" class="button-block" value="Back">
 </form:form>
</div>
</div>
</body>
</html>