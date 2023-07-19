<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.LeagueEntity" %>

<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Soccer League List</title>
</head>
<body bgcolor="white">

    <table border='1' cellpadding='5' cellspacing='0' width='400'>
        <tr bgcolor='teal' align='center' valign='center' height='20'>
            <td><h3>Soccer League: List Leagues</h3></td>
        </tr>
    </table>

    <p>List of soccer leagues: </p>

    <ul>
	    <% List<LeagueEntity> leagueList = (List<LeagueEntity>) request.getAttribute("leagueList");
	       if (leagueList != null) {
	           for (LeagueEntity league : leagueList) { %>
	               <li><%= league.getTitle() %></li>
	    <%     }
	       } %>
	</ul>

    <br/><br/>
    
    <a href='index.html'>Home</a>
</body>
</html>
