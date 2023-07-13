package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.League;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<League> leagueList = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		leagueList = new LinkedList<League>();
		leagueList.add(new League(2003, "Spring", "Soccer League (Spring '03)"));
		leagueList.add(new League(2003, "Summer", "Summer Soccer Fest 2003"));
		leagueList.add(new League(2003, "Fall", "Fall Soccer League (2003)"));
		leagueList.add(new League(2004, "Spring", "Soccer League (Spring '04)"));
		leagueList.add(new League(2004, "Summer", "The Summer of Soccer Love 2004"));
		leagueList.add(new League(2004, "Fall", "Fall Soccer League (2004)"));
		out.println("<html>");
		out.println("<head>");
		String pageTitle = "available leagues";
		out.println("<title>" + pageTitle + "</title>");
		out.println("</head>");
		out.println("<body bgcolor='white'>");

		out.println("<!-- Page Heading -->");
		out.println("<table border='1' cellpadding='5' cellspacing='0' width='400'>");
		out.println("<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>");

		out.println(" <td><h3>" + pageTitle + "</h3></td>");
		out.println("</tr>");
		out.println("</table>");

		out.println("<p>");
		out.println("The set of soccer leagues are:");
		out.println("</p>");

		out.println("<ul>");
		Iterator<League> items = leagueList.iterator();
		while (items.hasNext()) {
			League league = items.next();
			out.println(" <li>" + league.getTitle() + "</li>");
		}
		out.println("</ul>");

		out.println("</body>");
		out.println("</html>");
	}
}
