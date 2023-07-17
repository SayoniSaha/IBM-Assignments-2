package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCourseServlet extends HttpServlet {

	/**
	 * 
	 */
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
		PrintWriter out=response.getWriter();
		
		List<String> list=(List<String>) request.getAttribute("ERROR");
		if(list!=null) {
			out.println("<u>Error: </u><br/>");
			for(String s : list) {
				out.println("<font color='red'><li>"+ s +"</li></font>");
			}
		}
		
		out.println("<html><head><title>Add Course</title></head><body>");
		out.println("<p><h2>Add A New Course</h2></p><hr/>");
		out.println("<form action='course.do' method='post'>");
		out.println("<center><table><tr><td>Course:</td><td><input type='text' name='course'></td></tr>");
		out.println("<center><table><tr><td>Price:</td><td><input type='text' name='price'></td></tr>");
		out.println("</select></td></tr>");
		out.println("<tr><td><input type='submit' value='Add New Course'></table></form></body></html>");

	}
}

