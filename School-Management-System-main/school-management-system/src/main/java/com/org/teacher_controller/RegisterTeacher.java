package com.org.teacher_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.PrincipleDao;
import com.org.dao.TeacherDao;
import com.org.dto.Principle;
import com.org.dto.Teacher;

@WebServlet("/register_teacher")
public class RegisterTeacher extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String mobile = req.getParameter("mobile");
		String subject = req.getParameter("subject");
		String salary = req.getParameter("salary");
		String status = req.getParameter("status");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		int age1=Integer.parseInt(age);
		Long mobile1=Long.parseLong(mobile);
		Long salary1=Long.parseLong(salary);
		
		int principleId = Integer.parseInt(req.getParameter("principleId"));
		
		Principle principle = new PrincipleDao().fetchPrincipleById(principleId);
				
		Teacher teacher=new Teacher();
		
		teacher.setName(name);
		teacher.setAge(age1);
		teacher.setEmail(email);
		teacher.setPassword(password);
		teacher.setSalary(salary1);
		teacher.setSubject(subject);
		teacher.setStatus(status);
		teacher.setMobile(mobile1);
		
		teacher.setPrinciple(principle);
		
		List<Teacher> teachers=new ArrayList<>();
		teachers.add(teacher);
		
		principle.setTeachers(teachers);
		
		
		TeacherDao dao=new TeacherDao();
		dao.saveAndUpdate(teacher);
		
		HttpSession session = req.getSession();  
		session.setAttribute("sucess", "Registration sucessful");
		
		resp.sendRedirect("teacher/teacher_register.jsp");
		
		
		
		
		
	}
	

}
