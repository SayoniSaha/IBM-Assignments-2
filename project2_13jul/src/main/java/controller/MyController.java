package controller;

import model.Employee;

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
		int age=0;
		try {
			age=Integer.parseInt(request.getParameter("t2"));
			
		} catch (Exception e) {
			errors.add("Age should be numeric");
		}
		if(age<18) {
			errors.add("Age must be >=18");
		}
		
		if(!errors.isEmpty()) {
			request.setAttribute("ERROR", errors);
			RequestDispatcher view=request.getRequestDispatcher("error.view");
			view.forward(request, response);
		}
		else {
			Employee employee=new Employee(name, age);
			request.setAttribute("EMP", employee);
			RequestDispatcher view=request.getRequestDispatcher("success.view");
			view.forward(request, response);
		}
	}

}