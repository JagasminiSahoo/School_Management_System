package com.org.principle_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.PrincipleDao;
import com.org.dto.Principle;

@WebServlet("/update_principle")
public class UpdatePrinciple extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String qualification = req.getParameter("qualification");
		
		int age1=Integer.parseInt(age);
		Long mobile1=Long.parseLong(mobile);	
		
		PrincipleDao dao = new PrincipleDao();
		Principle principle = dao.fetchPrincipleById(id);
		
		principle.setName(name);
		principle.setAge(age1);
		principle.setEmail(email);
		principle.setMobile(mobile1);
		principle.setQualification(qualification);
		
		dao.saveAndUpdate(principle);
		
		HttpSession session = req.getSession();
		session.setAttribute("success","Profile Updated");
		resp.sendRedirect("principle/view_principle_profile.jsp");
		
	}

}
