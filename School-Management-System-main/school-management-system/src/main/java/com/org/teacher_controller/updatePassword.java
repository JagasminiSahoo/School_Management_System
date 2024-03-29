package com.org.teacher_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.TeacherDao;
import com.org.dto.Teacher;

@WebServlet("/change_password")
public class updatePassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
       
		HttpSession session = req.getSession();
		
		int id = ((Teacher) session.getAttribute("teacherObj")).getId();
		Teacher teacher = new TeacherDao().fetchTeacherById(id);
		
		String email1 = teacher.getEmail();
		String pass1=teacher.getPassword();
		
		if(email.equals(email1) && password.equals(pass1))
		{
			resp.sendRedirect("teacher/updatePass.jsp");
		}
		else
		{
			resp.sendRedirect("teacher/changepass.jsp");
		}
		

	}

}