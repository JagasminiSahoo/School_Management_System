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

@WebServlet("/principle_change_password")
public class UpdatePrinciplePassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
       
		HttpSession session = req.getSession();
		
		int id = ((Principle) session.getAttribute("principleObj")).getId();
		Principle principle = new PrincipleDao().fetchPrincipleById(id);
		
		String email1 = principle.getEmail();
		String pass1=principle.getPassword();
		
		if(email.equals(email1) && password.equals(pass1))
		{
			resp.sendRedirect("principle/principle_updatePass.jsp");
		}
		else
		{
			resp.sendRedirect("principle/principle_changepass.jsp");
		}
		

	}


}
