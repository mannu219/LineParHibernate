<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.ArrayList"%>
    <%@page import="com.test.bean.Student" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="<c:url value='/static/css/style1.css' />" rel="stylesheet"></link>
<title>ADMIN STUDENT DELETE</title>
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
<body>
 
<div class="form">
	<div class="tab-group">
	<h2>Delete Student :</h2>
 		<form:form action="./StudentControllerDelete">
		 	<div style="color: black;">
					<table border="1" width="600">
					<tr>
						<th  colspan="2">Username</th>
					</tr>
	
					<c:forEach var="element" items="${studentDisplay}">
					<tr>
						<td> ${element.username}</td>
						<td><input type="radio" name="username" value="${element.username}"></td>
					</tr>
					</c:forEach>
					</table>
 				</div><br>
 				<div id="dis">
					<h1>Please Select an User</h1>
 				</div>
 			<input type="submit" class="button-block" id="sub" value="delete" name="delete">
		</form:form>
		</div>
		<br>
	<form:form action="./AdminHomePage" method="post">
 <input type="submit" class="button-block" value="Back">
 </form:form>
	</div>
</body>
</html>