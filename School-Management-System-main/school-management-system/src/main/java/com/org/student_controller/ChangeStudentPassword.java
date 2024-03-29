package com.org.student_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.StudentDao;
import com.org.dto.Student;

@WebServlet("/student_ChangePassword")
public class ChangeStudentPassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");

		StudentDao dao = new StudentDao();
		Student student = dao.fetchStudentById(id);

		student.setPassword(password);

		dao.saveAndUpdate(student);

		HttpSession session = req.getSession();

		session.setAttribute("success", "password updated sucessfully");

		resp.sendRedirect("student/student_updatePass.jsp");
	}

}
