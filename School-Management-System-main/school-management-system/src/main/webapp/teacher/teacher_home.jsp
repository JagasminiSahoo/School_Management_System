<%@page import="com.org.dto.Teacher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<%@include file="../components/allcss.jsp"%>


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	Teacher teacher = (Teacher) session.getAttribute("teacherObj");
	
	
	if (teacher == null) {
		response.sendRedirect("teacher_login.jsp");
	}

	String status = teacher.getStatus();
	if (status.equalsIgnoreCase("inactive")) {
		response.sendRedirect("../components/blocked.jsp");
	} 
	else {
	%>
	<%@include file="../components/teacher_navbar.jsp"%>
	<h3 style="color: white; background-color: green; text-align: center"><marquee behavior="alternate" scrollamount="30">Welcome
		to Teacher Home page</marquee></h3>
	<h3 style="color: red; background-color: yellow; text-align: center">A
		teacher affects eternity; he can never tell where his influence stops</h3>

	<div id="carouselExampleInterval" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active" data-bs-interval="2000">
				<img src="../img/tchre1.jpg" class="d-block w-100" alt="..."
					height="600px">
			</div>
		</div>
	</div>

	<%
	}
	%>




</body>
</html>