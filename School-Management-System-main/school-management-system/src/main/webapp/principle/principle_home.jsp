<%@page import="com.org.dto.Principle"%>
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
	Principle principle = (Principle) session.getAttribute("principleObj");

	if (principle == null) {
		response.sendRedirect("principle_login.jsp");
	} else {
	%>
	<%@include file="../components/principle_navbar.jsp"%>
	<h3 style="color: green; background-color: red; text-align: center">Welcome
		to principal Home page</h3>

	<div id="carouselExampleInterval" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active" data-bs-interval="2000">
				<img src="../img/prnc1.jpg" class="d-block w-100"
					alt="..." height="800px">
			</div>
		</div>
	</div>

	<%
	}
	%>
</body>
</html>