package com.org.principle_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.PrincipleDao;
import com.org.dao.SchoolDao;
import com.org.dto.Principle;
import com.org.dto.School;

@WebServlet("/register_principle")
public class RegisterPrinciple extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String mobile = req.getParameter("mobile");
		String qualification = req.getParameter("qualification");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		int schid = Integer.parseInt(req.getParameter("schoolId"));
		
		
		
		int age1=Integer.parseInt(age);
		long mobile1=Long.parseLong(mobile);

		Principle principle=new Principle();
//		School school=new School();

		principle.setName(name);
		principle.setAge(age1);
		principle.setMobile(mobile1);
		principle.setQualification(qualification);
		principle.setEmail(email);
		principle.setPassword(password);
//		principle.setSchool(school);
		
		SchoolDao dao=new SchoolDao();
		School school = dao.fetchSchoolById(schid);
		
		principle.setSchool(school);
		school.setPrinciple(principle);

		PrincipleDao daoprinciple=new PrincipleDao();
		daoprinciple.saveAndUpdate(principle);

//		HttpSession session = req.getSession();  
//		session.setAttribute("sucess", "Registration sucessful");

		resp.sendRedirect("principle/principle_home.jsp");

	}

}
