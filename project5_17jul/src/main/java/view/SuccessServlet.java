package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.CourseEntity;
import factory.HibernateSessionFactory;
import model.Course;


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
		Course course = (Course) request.getAttribute("course");
		CourseEntity entity=new CourseEntity(course.getCourse(), course.getPrice());
		try {

			Session session = HibernateSessionFactory.getHibernateSession();
			session.getTransaction().begin();
			session.save(entity);
			session.getTransaction().commit();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		out.println("<h2>Course Added</h2><hr><br/>" + "Course:\n" + "<br/>Course name: " + course.getCourse() + "<br/>" + "Price: " + course.getPrice()
				+ "<br/><br/>");

		out.println("<a href='index.html'>Home</a>");

	}
}

