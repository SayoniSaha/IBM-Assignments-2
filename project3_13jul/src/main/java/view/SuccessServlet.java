package view;

	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import model.Student;

	public class SuccessServlet extends HttpServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
			request(request, response);
		}

		protected void request(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			Student student=(Student)request.getAttribute("EMP");
			out.println("Name: "+student.getName()+", Grade: "+student.getGrade());
		}
	}
