package com.org.student_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.PrincipleDao;
import com.org.dao.StudentDao;
import com.org.dao.TeacherDao;
import com.org.dto.Principle;
import com.org.dto.Student;
import com.org.dto.Teacher;

@WebServlet("/student_register")
public class RegisterStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		Long mobile = Long.parseLong(req.getParameter("mobile"));
		String course = req.getParameter("course");
		int marks = Integer.parseInt(req.getParameter("marks"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String status = req.getParameter("status");
		
		String pid = req.getParameter("principleId");
//		System.out.println(pid);
//		System.out.println(course);
		
		int teacherId = Integer.parseInt(course);
		int principleId = Integer.parseInt(pid);
		
		
		
		Principle p=new PrincipleDao().fetchPrincipleById(principleId);
		Teacher t=new TeacherDao().fetchTeacherById(teacherId);
		
		Student s=new Student();
		s.setName(name);
		s.setAge(age);
		s.setAddress(address);
		s.setEmail(email);
		s.setPassword(password);
		s.setMobile(mobile);
		s.setMarks(marks);
		s.setStatus(status);
		s.setCourse(t.getSubject());
		
		s.setPrinciple(p);
		s.setTeacher(t);
		
		List<Student> list=new ArrayList<>();
		list.add(s);
		
		p.setStudents(list);
		t.setStudents(list);
		
		StudentDao dao=new StudentDao();
		dao.saveAndUpdate(s);
		
		HttpSession session = req.getSession();
		session.setAttribute("sucess", "Registration sucessful");
		
		
		resp.sendRedirect("student/student_register.jsp");
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
