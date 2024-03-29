<%@page import="com.org.dto.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.StudentDao"%>
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
						<p class="fs-3 text-center">Student Details</p>

						<table class="table">
							<thead>
								<tr>
									<th>Full Name</th>
									<th>Age</th>
									<th>Mobile</th>
									<th>Email</th>
									<th>course</th>
									<th>address</th>
									<th>marks</th>
									<th>status</th>
								</tr>
							</thead>
							<tbody>
								<%
								StudentDao dao = new StudentDao();
								List<Student> students = dao.fetchAllStudents();

								for (Student s : students) {
								%>

								<tr>
									<td><%=s.getName()%></td>
									<td><%=s.getAge()%></td>
									<td><%=s.getMobile()%></td>
									<td><%=s.getEmail()%></td>
									<td><%=s.getCourse()%></td>
									<td><%=s.getAddress()%></td>
									<td><%=s.getMarks()%></td>

									<td>
										<%
										String status = s.getStatus();
										if (status.equalsIgnoreCase("active")) {
										%> <a class="btn btn-sm btn-danger"
										href="../update_student_status?id=<%=s.getId()%>"><i
											class="fa-solid fa-ban"></i> Block</a> <%
 } else {
 %> <a class="btn btn-sm btn-success "
										href="../update_student_status?id=<%=s.getId()%>"><i
											class="fa-regular fa-circle-check"></i> Unblock</a> <%
 }
 %>
									</td>
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