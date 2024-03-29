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

@WebServlet("/update_student")
public class UpdateStudent extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String marks = req.getParameter("marks");
		String course = req.getParameter("course");
		
		int age1=Integer.parseInt(age);
		Long mobile1=Long.parseLong(mobile);
		int marks1=Integer.parseInt(marks);
		
		StudentDao dao = new StudentDao();
		Student student = dao.fetchStudentById(id);
		
		student.setName(name);
		student.setAge(age1);
		student.setEmail(email);
		student.setMobile(mobile1);
		student.setCourse(course);
		student.setMarks(marks1);

		
		dao.saveAndUpdate(student);
		
		HttpSession session = req.getSession();
		session.setAttribute("success","Profile Updated");
		resp.sendRedirect("student/view_student_profile.jsp");
	}

}
