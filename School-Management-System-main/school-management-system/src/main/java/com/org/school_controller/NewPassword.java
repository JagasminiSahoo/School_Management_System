package com.org.school_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.SchoolDao;
import com.org.dao.SchoolDao;
import com.org.dto.School;
import com.org.dto.School;

@WebServlet("/newPassword")
public class NewPassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String t_id = req.getParameter("id");
		String new_psd = req.getParameter("newpsd");
		
		int tc_id=Integer.parseInt(t_id);
		System.out.println(tc_id);
		
		SchoolDao dao = new SchoolDao();
//		School school = dao.fetchSchoolById(tc_id);
		
		HttpSession session = req.getSession();
		School school = (School)session.getAttribute("schObj");
		
		school.setPassword(new_psd);

		dao.saveAndUpdate(school);
		
		HttpSession session2 = req.getSession();
		session2.setAttribute("ready", "Password Changed Sucessfully");
		
		resp.sendRedirect("school/school_login.jsp");
	}

}
