package com.org.school_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

import com.org.dao.SchoolDao;
import com.org.dto.School;

@WebServlet("/forgotPassword")
public class Forgot_Password extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();

		String userEmail = req.getParameter("email");

		String jpql = "select s from School s where s.email=?1";

		Query query = em.createQuery(jpql);

		query.setParameter(1, userEmail);

		List<School> list = query.getResultList();

		if (!list.isEmpty()) {
			School school = list.get(0);
			String dbEmail = school.getEmail();

			if (userEmail.equals(dbEmail)) {

				HttpSession session = req.getSession();
				session.setAttribute("schObj", school);

				RequestDispatcher rd = req.getRequestDispatcher("SchoolEmail");
				rd.forward(req, resp);
			}
		}

	}

}
