<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
    <link href="../stylemy.css" rel="stylesheet"/>
<script src="../js/homepage.js" type="text/javascript"></script>
<style>
.button{
  font-size:1rem;
  font-weight:300;
  }
input, textarea {
color:rgba(19, 35, 47, 0.9);
}  
</style>
</head>
<body>
<div class="form">
    <div class="wrap">
        <h1 id="construct">Almonds, Help You Boost Your Memory.</h1>
<form action="../forgetPass" method="post">
        <div class="type-wrap">
            <div id="typed-strings">
                <span>Enter Your Registered Email Address</span>
            <div class="field-wrap">
            <input type="email"  name="email" required autocomplete="off"/>
          	</div>
          	<button type="submit" class="button button-block"/>Reset Password</button>
          	
				<p>Click On The Below Links for Navigations.</p>
            </div>
            <span id="typed" style="white-space:pre;"></span>
        </div>
        </form>

        <div class="links">
           <a href="home.jsp">Home</a> |  <a href="https://hurkat.in">Mohit Hurkat</a> | <a href="https://www.facebook.com/mohit.hurkat">Facebook</a> | <a href="https://twitter.com/mohithurkat">Twitter</a>
        </div>
    </div>
</div>
</body>
</html>