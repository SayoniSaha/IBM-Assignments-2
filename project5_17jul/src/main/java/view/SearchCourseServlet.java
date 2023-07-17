package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.CourseEntity;
import factory.HibernateSessionFactory;

public class SearchCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processesRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processesRequest(request, response);
    }

    protected void processesRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String courseName = request.getParameter("course");

        try {
            Session session = HibernateSessionFactory.getHibernateSession();
            Query<CourseEntity> query = session.createQuery("FROM CourseEntity C WHERE C.course = :courseName",
                    CourseEntity.class);
            query.setParameter("courseName", courseName);
            CourseEntity course = query.uniqueResult();

            if (course != null) {
                out.println("<html><head><title>Course Details</title></head><body>");
                out.println("<h2>Course Details</h2><hr><br/>" + "Course Name: " + course.getCourse() + "<br/>"
                        + "Price: " + course.getPrice() + "<br/><br/>");
                out.println("<a href='index.html'>Home</a>");
                out.println("</body></html>");
            } else {
                out.println("<html><head><title>Course Details</title></head><body>");
                out.println("<h2>Course Details</h2><hr><br/>");
                out.println("<p>Course not found</p>");
                out.println("<a href='index.html'>Home</a>");
                out.println("</body></html>");
            }
        } catch (Exception e) {
            out.println("<html><head><title>Error</title></head><body>");
            out.println("<h2>Error</h2><hr><br/>");
            out.println("<p>An error occurred while processing the request.</p>");
            out.println("<p>Error details: " + e.getMessage() + "</p>");
            out.println("</body></html>");
            e.printStackTrace();
        }
    }
}
