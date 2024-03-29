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

@WebServlet("/student_change_password")
public class UpdateStudentPassword  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
       
		HttpSession session = req.getSession();
		
		int id = ((Student) session.getAttribute("studentObj")).getId();
		Student student = new StudentDao().fetchStudentById(id);
		
		String email1 = student.getEmail();
		String pass1=student.getPassword();
		
		if(email.equals(email1) && password.equals(pass1))
		{
			resp.sendRedirect("student/student_updatePass.jsp");
		}
		else
		{
			resp.sendRedirect("student/student_changepass.jsp");
		}
		

	}

}
