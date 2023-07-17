// MyServlet.java
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.CourseEntity;
import factory.HibernateSessionFactory;

public class MyServlet extends HttpServlet {

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

        try {
            Session session = HibernateSessionFactory.getHibernateSession();
            TypedQuery<CourseEntity> query = session.createQuery("FROM CourseEntity", CourseEntity.class);
            List<CourseEntity> courseList = query.getResultList();

            out.println("<html>");
            out.println("<head>");
            String pageTitle = "List Available Courses";
            out.println("<title>" + pageTitle + "</title>");
            out.println("</head>");
            out.println("<body bgcolor='white'>");

            out.println("<!-- Page Heading -->");
            out.println("<table border='1' cellpadding='5' cellspacing='0' width='400'>");
            out.println("<tr bgcolor='teal' align='center' valign='center' height='20' width='1000'>");
            out.println(" <td><h3>" + pageTitle + "</h3></td>");
            out.println("</tr>");
            out.println("</table>");

            out.println("<p>");
            out.println("List of courses - ");
            out.println("</p>");

            out.println("<ul>");
            for (CourseEntity courseEntity : courseList) {
                out.println(" <li>" + courseEntity.getCourse() + " - " + courseEntity.getPrice() + "</li>");
            }
            out.println("</ul><br/><br/>");
            out.println("<a href='index.html'>Home</a>");

            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
