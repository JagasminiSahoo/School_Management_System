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

@WebServlet("/teacherNewPassword")
public class TeacherNewPassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String p_id = req.getParameter("id");
		String new_psd = req.getParameter("newpsd");
		
		int pr_id=Integer.parseInt(p_id);
		System.out.println(pr_id);
		
		TeacherDao dao = new TeacherDao();
//		Teacher teacher = dao.fetchTeacherById(tc_id);
		
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teaObj");
		
		teacher.setPassword(new_psd);

		dao.saveAndUpdate(teacher);
		
		HttpSession session2 = req.getSession();
		session2.setAttribute("ready", "Password Changed Sucessfully");
		
		resp.sendRedirect("teacher/teacher_login.jsp");
	}


}
