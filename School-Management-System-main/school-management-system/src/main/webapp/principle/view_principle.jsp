<%@page import="com.org.dto.Principle"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.PrincipleDao"%>
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
	<%@ include file="../components/principle_navbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Principal Details</p>

						<table class="table">
							<thead>
								<tr>
									<th>Full Name</th>
									<th>Age</th>
									<th>Mobile</th>
									<th>Qualification</th>
									<th>Email</th>
									
								</tr>
							</thead>
							<tbody>
								<%
								PrincipleDao dao = new PrincipleDao();
								List<Principle> principles = dao.fetchAllPrinciples();

								for (Principle p : principles) {
								%>

								<tr>
									<td><%=p.getName()%></td>
									<td><%=p.getAge()%></td>
									<td><%=p.getMobile()%></td>
									<td><%=p.getQualification()%></td>
									<td><%=p.getEmail()%></td>
									<td>Actions</td>
								</tr>




								<%
								}
								%>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>