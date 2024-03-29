package com.org.teacher_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.TeacherDao;
import com.org.dto.Teacher;

@WebServlet("/update_teacher")
public class UpdateTeacher extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		int age1=Integer.parseInt(age);
		Long mobile1=Long.parseLong(mobile);	
		
		TeacherDao dao = new TeacherDao();
		Teacher teacher = dao.fetchTeacherById(id);
		
		teacher.setName(name);
		teacher.setAge(age1);
		teacher.setEmail(email);
		teacher.setMobile(mobile1);
		
		dao.saveAndUpdate(teacher);
		
		HttpSession session = req.getSession();
		session.setAttribute("success","Profile Updated");
		resp.sendRedirect("teacher/view_teacher_profile.jsp");
		
		
	}

}
