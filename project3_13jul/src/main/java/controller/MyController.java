package controller;

import model.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errors=new ArrayList<String>();	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("t1");
		if(name.length()<=0) {
			errors.add("Name field is blank");
		}
		double grade=0;
		try {
			grade=Double.parseDouble(request.getParameter("t2"));
			
		} catch (Exception e) {
			errors.add("Invalid grade");
		}
		
		if(!errors.isEmpty()) {
			request.setAttribute("ERROR", errors);
			RequestDispatcher view=request.getRequestDispatcher("error.view");
			view.forward(request, response);
		}
		else {
			Student student=new Student(name, grade);
			request.setAttribute("STUDENT", student);
			RequestDispatcher view=request.getRequestDispatcher("success.view");
			view.forward(request, response);
		}
	}

}

