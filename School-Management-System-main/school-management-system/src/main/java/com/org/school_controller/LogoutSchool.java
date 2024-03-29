package com.org.school_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/schoolLogout")
public class LogoutSchool extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		
//		session.removeAttribute("schoolObj");
		session.invalidate();
		
		resp.sendRedirect("school/school_home.jsp");
	}

}
