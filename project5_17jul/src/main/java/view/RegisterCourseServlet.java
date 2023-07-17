package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.MyController;

public class RegisterCourseServlet extends HttpServlet {
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

        List<String> list = (List<String>) request.getAttribute("ERROR");
        if (list != null) {
            out.println("<u>Correct the following error(s)</u><br/>");
            for (String s : list) {
                out.println("<font color='yellow'><li>" + s + "</li></font>");
            }
        }

        String selectedCourse = request.getParameter("course");
        String selectedPrice = getSelectedPrice(selectedCourse);

        Map<String, String> coursePriceMap = MyController.getCoursePriceMap();

        out.println("<html><head><title>Register Course</title></head><body>");
        out.println("<p><h2>Register to a new Course</h2></p><hr/>");
        out.println("<form action='course.do' method='post'>");
        out.println("<tr><td>Course</td><td><select name='course'><option value='course'>Select-</option>");
        for (Map.Entry<String, String> entry : coursePriceMap.entrySet()) {
            String course = entry.getKey();
            String price = entry.getValue();
            out.println("<option value='" + course + "'>" + course + "</option>");
        }
        out.println("</select></td></tr>");
        out.println("<tr><td>Price</td><td><select name='price'><option value='Unknown'>Select-</option>");
        for (Map.Entry<String, String> entry : coursePriceMap.entrySet()) {
            String course = entry.getKey();
            String price = entry.getValue();
            if (selectedCourse != null && selectedCourse.equals(course)) {
                out.println("<option value='" + price + "' selected>" + price + "</option>");
            } else {
                out.println("<option value='" + price + "'>" + price + "</option>");
            }
        }
        out.println("</select></td></tr>");
        out.println("<tr><td><input type='submit' value='Register New Course'></table></form></body></html>");
		out.println("<a href='index.html'>Home</a>");

    }

    private String getSelectedPrice(String course) {
        Map<String, String> coursePriceMap = MyController.getCoursePriceMap();
        if (course != null && coursePriceMap.containsKey(course)) {
            return coursePriceMap.get(course);
        }
        return null;
    }
}
