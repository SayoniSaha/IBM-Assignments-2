//package com.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.model.League;
//
//public class AddLeagueController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		processesRequest(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		processesRequest(request, response);
//	}
//
//	protected void processesRequest(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		response.setContentType("text/html");
//
//		int year = 0;
//		String season = null;
//		String title = null;
//		List<String> errors = new ArrayList<String>();
//
//		season = request.getParameter("season");
//		if (season.equals("Unknown")) {
//			errors.add("Select a season");
//
//		}
//		title=request.getParameter("title");
//		if(title.length()<=0)
//		{
//			errors.add("Title can not be empty");
//		}
//		
//		try {
//			year=Integer.parseInt(request.getParameter("year"));
//			if(year<2023)
//			{
//				errors.add("Year must be >= 2023");
//			}
//			
//		} catch (Exception e) {			
//			errors.add("Year must be numeric");
//		}
//		
//		if(!errors.isEmpty())
//		{
//			request.setAttribute("ERROR", errors);
//			RequestDispatcher view=request.getRequestDispatcher("add_league.jsp");
//			view.forward(request, response);
//		}
//		
//		else
//		{
//			request.setAttribute("LEAGUE", new League(year, season, title));
//			RequestDispatcher view=request.getRequestDispatcher("success.view");
//			view.forward(request, response);
//		}
//
//	}
//}


package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.LeagueEntity;

@Controller
public class AddLeagueController {

    private DataSource dataSource;

    @Autowired
    public AddLeagueController(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @GetMapping
    public String goIndex() {
        return "index";
    }
    
    @GetMapping("/add_league")
    public String showAddLeagueForm() {
        return "add_league";
    }

    @PostMapping("/addLeague")
    public String addLeague(@RequestParam(name="year") int year, @RequestParam(name="season") String season,@RequestParam(name="title") String title,
                            Model model) {

        List<String> errors = new ArrayList<String>();

        if (season.equals("Unknown")) {
            errors.add("Select a season");
        }

        if (title.length() <= 0) {
            errors.add("Title cannot be empty");
        }

        if (year < 2023) {
            errors.add("Year must be >= 2023");
        }

        if (!errors.isEmpty()) {
            model.addAttribute("ERROR", errors);
            return "add_league";
        }
        List<LeagueEntity> leagueList = getLeaguesFromDatabase();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "insert into league (year, season, title) values (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, year);
                pstmt.setString(2, season);
                pstmt.setString(3, title);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute("leagueList", leagueList);
        return "success";
    }
    
    @GetMapping("/list_league")
    public String listLeague(Model model) {
    	List<LeagueEntity> leagueList = getLeaguesFromDatabase();
    	
    	model.addAttribute("leagueList", leagueList);
    	return "list_league";
    }



    private List<LeagueEntity> getLeaguesFromDatabase() {
        List<LeagueEntity> leagueList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "select * from league";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int year = rs.getInt("year");
                    String season = rs.getString("season");
                    String title = rs.getString("title");
                    LeagueEntity league = new LeagueEntity(year, season, title);
                    leagueList.add(league);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return leagueList;
    }
}
