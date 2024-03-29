package com.org.teacher_controller;

import java.io.IOException;
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TeacherEmail")
public class TeacherEmail extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Properties properties = System.getProperties();

		// step 1
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.ssl.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");

		// step 2
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("abcxyz9r@gmail.com", "usaa iqbz dcpo rnsj");
			}
		});

		session.setDebug(true);

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom("abcxyz9r@gmail.com");

			message.addRecipient(Message.RecipientType.TO, new InternetAddress("ddddebendra@gmail.com"));

			message.setSubject("Otp verification");

			Random rd = new Random();
			String otp = "" + rd.nextInt(9) + rd.nextInt(9) + rd.nextInt(9) + rd.nextInt(9) + "";
			
			
			
			message.setText(otp);

			Transport.send(message);
			
			HttpSession session2 = req.getSession();
			session2.setAttribute("GeOtp", otp);
			resp.sendRedirect("teacher/teacher_verify_email.jsp");

//			System.out.println("message sent");

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
