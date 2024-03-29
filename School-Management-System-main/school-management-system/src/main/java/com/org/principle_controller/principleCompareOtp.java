package com.org.principle_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/principleComparePassword")
public class principleCompareOtp  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String u_otp = req.getParameter("otp");
		
		HttpSession session = req.getSession();
		String g_otp = (String)session.getAttribute("GeOtp");
		
		if(u_otp.equals(g_otp))
		{
			resp.sendRedirect("principle/principleNewPassword.jsp");
		}
		else
		{
			resp.sendRedirect("principle/principle_verify_email.jsp");
		}
	}


}
