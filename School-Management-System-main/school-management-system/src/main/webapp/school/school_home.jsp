<%@page import="com.org.dto.School"%>
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
	School school = (School) session.getAttribute("schoolObj");

	if (school == null) {
		response.sendRedirect("school_login.jsp");
	} else {
	%>
	<%@include file="../components/school_navbar.jsp"%>
	<h3
		style="color: red; background-color: yellow; text-align: center; text-font: italic">Welcome
		to School Home page</h3>

	
	<div id="carouselExampleInterval" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active" data-bs-interval="2000">
				<img src="../img/schh.jpg" class="d-block w-100" alt="..."
					height="580px">
			</div>

		</div>
	</div>
	<h3
		style="color: black; background-color: yellow; text-align: center; text-font: italic"><marquee behavior="alternate" scrollamount="10">Education
		is the most powerful weapon which you can use to change the world.</marquee></h3>
	


	<%
	}
	%>


</body>
</html>