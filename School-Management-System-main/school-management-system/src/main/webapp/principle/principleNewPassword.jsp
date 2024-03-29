<%@page import="com.org.dao.PrincipleDao"%>
<%@page import="com.org.dto.Principle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@ include file="../components/navbar.jsp"%>
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car paint-card">
					<div class="card-body">
					<%
						Principle principle1 = (Principle) session.getAttribute("priObj");
						int id = principle1.getId();
						Principle principle = new PrincipleDao().fetchPrincipleById(id);
						%>
						<p class="fs-4 text-center">Enter New Password</p>

						<form action="../principleNewPassword" method="post">
						
						<input type="hidden" name="id" value="<%=principle.getId()%>">
							<div class="mb-3">
								<label class="form-label">Enter Password</label> <input
									name="newpsd" type="password" class="form-control" required>
							</div>
							
								<button type="submit" class="btn bg-success text-white col-md-12">Submit</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>