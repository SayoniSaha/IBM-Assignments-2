package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddLeagueViewServlet extends HttpServlet {

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
		
		@SuppressWarnings("unchecked")
		List<String> list=(List<String>) request.getAttribute("ERROR");
		if(list!=null)
		{
			out.println("<u>Please correct the bellow error(s)</u><br/>");
			for(String s:list)
			{
				out.println("<font color='red'><li>"+s+"</li></font>");
			}
		}
		
		String str=getServletConfig().getInitParameter("seasons");//Summer,Winter,Autumn,Rain
		String[] seasons=str.split(",");
		out.println("<html><head><title>Add Leage</title></head><body>");
		out.println("<p><h2>Add A New League</h2></p><hr/>");
		out.println("<form action='add_league.do' method='post'>");
		out.println("<center><table><tr><td>Year</td><td><input type='text' name='year'></td></tr>");
		
		out.println("<tr><td>Season</td><td><select name='season'><option value='Unknown'>Select...</option>");
		
		for(String s:seasons)
		{
			out.println("<option value='"+s+"'>"+s+"</option>");
		}
		out.println("</select></td></tr>");
		out.println("<tr><td>Title</td><td><input type='text' name='title'></td></tr>");
		out.println("<tr><td><input type='submit' value='Add New League'></table></form></body></html>");

	}
}
