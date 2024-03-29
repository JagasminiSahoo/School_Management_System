package com.org.school_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/comparePassword")
public class comparePassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String u_otp = req.getParameter("otp");
		
		HttpSession session = req.getSession();
		String g_otp = (String)session.getAttribute("GeOtp");
		
		if(u_otp.equals(g_otp))
		{
			resp.sendRedirect("school/newPassword.jsp");
		}
		else
		{
			resp.sendRedirect("school/verify_email.jsp");
		}
	}

}
