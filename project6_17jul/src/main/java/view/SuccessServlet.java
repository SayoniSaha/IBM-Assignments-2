package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.entity.LeagueEntity;
import com.factory.HibernateSessionFactory;
import com.model.League;

public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processesRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processesRequest(request, response);
	}

	private void processesRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException	 {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		League league = (League) request.getAttribute("LEAGUE");
		LeagueEntity entity=new LeagueEntity(league.getYear(), league.getSeason(), league.getTitle());
		try {
			
		
		Session session=HibernateSessionFactory.getHibernateSession();
		session.getTransaction().begin();
		session.save(entity);
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		out.println("<h2>League Added Sucessfully</h2><hr><br/>" + "League year: " + league.getYear()
				+ "<br/>League season: " + league.getSeason() + "<br/>" + "League title: " + league.getTitle()
				+ "<br/><br/>");

		out.println("<a href='index.html'>Home</a>");

	}
}
