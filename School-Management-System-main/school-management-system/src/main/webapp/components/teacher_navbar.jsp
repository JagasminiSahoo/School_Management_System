<%@page import="com.org.dto.Teacher"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="../main/index.jsp"><i
			class="fa-solid fa-school"></i>MoSchool</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">

				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="../student/view_student.jsp"><i
						class="fa-regular fa-eye"></i>view student</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="../teacher/view_teacher_profile.jsp"><i
						class="fa-regular fa-eye"></i>view profile</a></li>

				<%
				Teacher t = (Teacher) session.getAttribute("teacherObj");
				%>
			</ul>
		</div>

		<div class="dropdown">
			<button class="btn btn-secondary dropdown-toggle" type="button"
				id="dropdownMenuButton1" data-bs-toggle="dropdown"
				aria-expanded="false">More</button>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="../teacher/changepass.jsp"><i
						class="fa-solid fa-lock"></i>Change Password</a></li>

				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="../teacherLogout"><i
						class="fa-solid fa-right-from-bracket"></i>Logout</a></li>

			</ul>
		</div>




	</div>

</nav>