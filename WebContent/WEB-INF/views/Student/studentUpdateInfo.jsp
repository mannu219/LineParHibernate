<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="com.test.bean.Student" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPDATE INFORMATION</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="<c:url value='/static/css/stylemy.css'/>" rel="stylesheet" type="text/css"/>
<script src="<c:url value="/static/javascript/homepage.js" />"></script>
    <script>
$(document).ready(function() {
        $("#updateInfo").addClass("active");
});

function Validation() {
	    var x = document.getElementById("updatePassword").value;
	    var y = document.getElementById("confirmPassword").value;
	    if(x!=y){
	    	alert("Password doesn't match.");
	    	 document.getElementById('confirmPassword').value="";
	    	 document.getElementById('updatePassword').value="";
	    	return false;
	    }
	    return true;
	
}
</script>
</head>
<body>
<div class="form">
<h1> Update Information </h1>
<form:form action="./StudentUpdate" method="post" commandName="student">
          
          <div class="top-row">
          	<div class="field-wrap">
          	<form:label path="name">Update Name :</form:label> 
          	 <form:input path="name" type="text" value="${student.name}"  /> 
              <form:errors path="name"></form:errors>
            </div>
			<div class="field-wrap">
             <form:label path="email">Update Email Address :</form:label> 
			 <form:input path="email"  type="text"  value="${student.email}"  />  
             <form:errors path="email"></form:errors>
          	</div>
            <div class="field-wrap">
            	<form:label path="password">Update Password(0-9,A-Z,a-z required) :</form:label> 
				<form:input path="password"  type="password" id="updatePassword" />  
             <form:errors path="password"></form:errors>
           
          	</div>   
          	<div class="field-wrap">
          	<form:label path="password">Confirm Password :</form:label> 
			<form:input path="password"  type="password"  id="confirmPassword"  onBlur="Validation();"/>  
             <form:errors path="password"></form:errors>
           
          	</div>  
          	<div class="field-wrap">
           	<form:label path="phone">Update Phone No(10 digits) : </form:label> 
			<form:input path="phone" type="text" value="${student.phone}"  />
            <form:errors path="phone"></form:errors> 
            </div>
            
          <input type="submit" class="button button-block" value="Update">
          </div><!-- top-row -->
</form:form><br>

 <form:form action="./StudentBack" method="post">
			<input type="submit" class="button-block" value="Back">
		</form:form>
</div>
</body>
</html>