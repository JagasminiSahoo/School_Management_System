<%@page import="com.org.dto.School"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
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
					aria-current="page" href="../principle/principle_register.jsp"><i
						class="fa-solid fa-address-card"></i>Add Principal</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="../principle/view_principle.jsp"><i
						class="fa-solid fa-eye"></i>view pricipal</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="../student/view_student.jsp"><i
						class="fa-solid fa-eye"></i>view Student</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="../teacher/view_teacher.jsp"><i
						class="fa-solid fa-eye"></i>view Teacher</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="../schoolLogout"><i
						class="fa-solid fa-right-from-bracket"></i>Logout</a></li>

			</ul>

		</div>
	</div>
</nav>