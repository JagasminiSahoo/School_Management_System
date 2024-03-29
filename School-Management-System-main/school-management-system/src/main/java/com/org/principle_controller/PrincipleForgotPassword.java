package com.org.principle_controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dto.Principle;
import com.org.dto.School;

@WebServlet("/principle_forgotPassword")
public class PrincipleForgotPassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();

		String userEmail = req.getParameter("email");

		String jpql = "select s from  Principle s where s.email=?1";

		Query query = em.createQuery(jpql);

		query.setParameter(1, userEmail);

		List<Principle> list = query.getResultList();

		if (!list.isEmpty()) {
			Principle principle = list.get(0);
			String dbEmail = principle.getEmail();

			if (userEmail.equals(dbEmail)) {

				HttpSession session = req.getSession();
				session.setAttribute("priObj", principle);

				RequestDispatcher rd = req.getRequestDispatcher("PrincipleEmail");
				rd.forward(req, resp);
			}
		}

	}

}
