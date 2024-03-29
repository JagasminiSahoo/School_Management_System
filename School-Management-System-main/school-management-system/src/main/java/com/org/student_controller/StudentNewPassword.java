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

@WebServlet("/studentNewPassword")
public class StudentNewPassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String p_id = req.getParameter("id");
		String new_psd = req.getParameter("newpsd");
		
		int pr_id=Integer.parseInt(p_id);
		System.out.println(pr_id);
		
		StudentDao dao = new StudentDao();
//		Student student = dao.fetchStudentById(tc_id);
		
		HttpSession session = req.getSession();
		Student student = (Student)session.getAttribute("stuObj");
		
		student.setPassword(new_psd);

		dao.saveAndUpdate(student);
		
		HttpSession session2 = req.getSession();
		session2.setAttribute("ready", "Password Changed Sucessfully");
		
		resp.sendRedirect("student/student_login.jsp");
	}

}
