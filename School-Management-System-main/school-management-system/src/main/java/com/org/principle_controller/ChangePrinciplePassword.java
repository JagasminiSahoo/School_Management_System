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

@WebServlet("/principle_ChangePassword")
public class ChangePrinciplePassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");

		PrincipleDao dao = new PrincipleDao();
		Principle principle = dao.fetchPrincipleById(id);

		principle.setPassword(password);

		dao.saveAndUpdate(principle);

		HttpSession session = req.getSession();

		session.setAttribute("success", "password updated sucessfully");

		resp.sendRedirect("principle/principle_updatePass.jsp");
	}


}
