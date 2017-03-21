<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN HOME PAGE</title>
 <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" />"></script>
<link href="<c:url value='/static/css/admin.css' />" rel="stylesheet"></link>
 
    <script>
	var audio = new Audio('../heartbeat.mp3');
    audio.play();
    </script>
</head>
<body>

	<div class="form">
      <h1>Welcome Admin</h1>
      	<ul class="tab-group">
        	<li class="tab " id="question"><a>Question</a>
        	<ul class="dropdown-content">
        		 
        		
        	 			<!--******* passing to AdminQuestionController******** -->
        	 			
        		<li class="float"><a href="./AdminQuestionDelete"> Delete Question</a></li> 
        		<li class="float"><a href="./AdminQuestionInsert">Insert Question</a></li>
        		<li  class="float"><a href="./AdminQuestionUpdate">Update Question</a></li>
        		<li  class="float"><a href="./AdminQuestionView"> View All Questions</a></li>
        	</ul>
        	</li>
        	<li class="tab" id="updateInfo"><a>Student</a>
        	<ul class="dropdown-content">
        	 
        		<li class="float"><a  href="./AdminStudentHelperDisplay">Delete Student</a></li>
        		<li class="float"><a  href="./AdminStudentHelperSearch">Search Student</a></li>
        		<li class="float"><a  href="./AdminStudentHelperDisplayAll">View All Students</a></li>
        	</ul>
			 </li>
         	<li class="tab " id="subject" ><a>Subject</a>
         	<ul class="dropdown-content">
        		 
        		<li class="float"><a href="./SubjectHelperDisplay">Delete Subject</a></li>
        		<li class="float"><a href="./SubjectHelperDisplay1">Display Subject</a></li>
        		<li class="float"><a href="./AdminSubjectInsertSubject">Insert Subject</a></li>
        		<li class="float"><a href="./SubjectHelperDisplay3">Search Subject</a></li>
        		<li class="float"><a href="./SubjectHelperDisplay2">Update Subject</a></li>
        	</ul>
        	</li>
        	<li class="tab " id="update" ><a>Admin</a>
        	<ul class="dropdown-content">
        		 
        		<li class="float"><a href="./Admin/AdminAdmin/adminAdmin.jsp">Update Admin</a></li>
        	</ul>
        	</li>
		</ul>
	</div> <!-- /form -->
 <%@include file="../Test/logout.jsp" %> 
</body>
</html>