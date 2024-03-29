package com.org.student_controller;

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

import com.org.dto.Student;

@WebServlet("/student_forgotPassword")
public class StudentForgotPassword extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();

		String userEmail = req.getParameter("email");

		String jpql = "select s from  Student s where s.email=?1";

		Query query = em.createQuery(jpql);

		query.setParameter(1, userEmail);

		List<Student> list = query.getResultList();

		if (!list.isEmpty()) {
			Student student = list.get(0);
			String dbEmail = student.getEmail();

			if (userEmail.equals(dbEmail)) {

				HttpSession session = req.getSession();
				session.setAttribute("stuObj", student);

				RequestDispatcher rd = req.getRequestDispatcher("StudentEmail");
				rd.forward(req, resp);
			}
		}


	}


}
