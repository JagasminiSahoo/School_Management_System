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

@WebServlet("/principleNewPassword")
public class PrincipleNewPassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String p_id = req.getParameter("id");
		String new_psd = req.getParameter("newpsd");
		
		int pr_id=Integer.parseInt(p_id);
		System.out.println(pr_id);
		
		PrincipleDao dao = new PrincipleDao();
//		Principle principle = dao.fetchPrincipleById(tc_id);
		
		HttpSession session = req.getSession();
		Principle principle = (Principle)session.getAttribute("priObj");
		
		principle.setPassword(new_psd);

		dao.saveAndUpdate(principle);
		
		HttpSession session2 = req.getSession();
		session2.setAttribute("ready", "Password Changed Sucessfully");
		
		resp.sendRedirect("principle/principle_login.jsp");
	}

}
