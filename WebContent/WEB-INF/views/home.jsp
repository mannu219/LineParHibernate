<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 
<html>
<head>
 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>ONLINE TEST</title>
 <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" />"></script>
<link href="<c:url value='/static/css/stylemy.css'/>" rel="stylesheet" type="text/css"/>
<script src="<c:url value="/static/javascript/homepage.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.tab a').on('click', function(e) {

			e.preventDefault();

			$(this).parent().addClass('active');
			$(this).parent().siblings().removeClass('active');

			var target = $(this).attr('href');
			$('.tab-content > div').not(target).hide();

			$(target).fadeIn(600);

		});
	});
</script>

 
</head>
<body>
	<div class="form">

	 <ul class="tab-group">
			<li class="tab active"><a href="#signup">Sign Up</a></li>
			<li class="tab"><a href="#login">Log In</a></li>
		</ul>
 
		<div class="tab-content">
			<div id="signup">
				<h1 class="sign">Sign Up</h1>

		<%-- 		<form action="./StudentController" method="post"> --%>
				<form:form method="post" action="./StudentController" commandName="student">
					<div class="top-row">

						<div class="field-wrap">
							 <form:label path="name"> <spring:message code="label.name"> </spring:message></form:label> 
							 <form:input path="name" type="text"></form:input> 
							 <form:errors path="name"></form:errors> 
						</div>
						<div class="field-wrap">
							 <form:label path="email"><spring:message code="label.email"></spring:message></form:label> 
        				 	<form:input path="email" type="email"></form:input> 
							  <form:errors path="email"></form:errors> 
						</div>
						<div class="field-wrap">
						   <form:label path="phone"><spring:message code="label.phone"></spring:message></form:label> 
        					<form:input path="phone" type="number"></form:input>
							 <form:errors path="phone"></form:errors> 
						</div>
						<div class="field-wrap">
							 <form:label path="username"><spring:message code="label.username"></spring:message></form:label> 
        					<form:input path="username" type="text"></form:input>  
							 <form:errors path="username"></form:errors> 		 
						</div>
						<div class="field-wrap">
						   <form:label path="password"><spring:message code="label.password"></spring:message></form:label> 
        					<form:input path="password" type="password"></form:input>  
							 <form:errors path="password"></form:errors>
							 
						</div>

						<form:button type="submit" class="button button-block" name="insert">Sign Up</form:button>
						
						
					</div>
					</form:form>
					<!-- top-row -->
				<%-- </form> --%>
			</div>

			<div id="login">
				<h1>Welcome Back!</h1>

				<%-- <form action="./signIn" method="post"> --%>
				<form:form method="post" action="./Admin" commandName="user">
					<div class="field-wrap">
							<form:label path="username"><spring:message code="label.username"></spring:message></form:label> 
        					<form:input path="username" type="text"></form:input>  
							 <form:errors path="username"></form:errors> 	
					</div>

					<div class="field-wrap">
						 <form:label path="password"><spring:message code="label.password"></spring:message></form:label> 
        				 <form:input path="password" type="password"></form:input>  
						 <form:errors path="password"></form:errors>
						  
					</div>

					 
					<button class="button button-block" name="login">Log In</button>
				<%-- </form> --%>
					</form:form>
			</div>
			<!-- login -->
		</div>
		<!-- tab-content -->

<b>Change Language :<a href=" http://localhost:4040/LineParTest/?lang=en">English</a> |
 					<a href="http://localhost:4040/LineParTest/?lang=fr_FR">French</a> | 
 					<a href="http://localhost:4040/LineParTest/?lang=hi_IN ">Hindi</a>
 </b>
	</div>
	<!-- /form -->
</body>
</html>