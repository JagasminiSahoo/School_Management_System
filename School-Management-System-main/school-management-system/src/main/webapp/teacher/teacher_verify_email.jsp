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
						<p class="fs-4 text-center">Enter OTP</p>

						<form action="../teacherComparePassword" method="post">
							<div class="mb-3">
								<label class="form-label">Enter OTP</label> <input
									name="otp" type="text" class="form-control" required>
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