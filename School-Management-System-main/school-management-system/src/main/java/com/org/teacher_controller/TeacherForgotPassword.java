package com.org.teacher_controller;

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

import com.org.dto.Teacher;

@WebServlet("/teacher_forgotPassword")
public class TeacherForgotPassword  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();

		String userEmail = req.getParameter("email");

		String jpql = "select s from  Teacher s where s.email=?1";

		Query query = em.createQuery(jpql);

		query.setParameter(1, userEmail);

		List<Teacher> list = query.getResultList();

		if (!list.isEmpty()) {
			Teacher teacher = list.get(0);
			String dbEmail = teacher.getEmail();

			if (userEmail.equals(dbEmail)) {

				HttpSession session = req.getSession();
				session.setAttribute("teaObj", teacher);

				RequestDispatcher rd = req.getRequestDispatcher("TeacherEmail");
				rd.forward(req, resp);
			}
		}


	}

}
