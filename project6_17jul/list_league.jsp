<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@page import="javax.persistence.TypedQuery"%>
<%@page import="org.hibernate.Session"%>

<%@page import="model.League"%>
<%@page import="entity.LeagueEntity"%>

<%@page import="factory.MyHibernateSessionFactory"%>

    
<!DOCTYPE html>
<html>
<head>
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
        <% List<LeagueEntity> leagueList = null; %>
        <% try{ Session sf = MyHibernateSessionFactory.getHibernateSession();
        		TypedQuery<LeagueEntity> tq = sf.createQuery("From LeagueEntity L",LeagueEntity.class);
        		leagueList = tq.getResultList();
           } catch (Exception e) {
           e.printStackTrace();
           } %>
        
        <% if (leagueList != null) {
		    Iterator<LeagueEntity> i = leagueList.iterator();
		    while (i.hasNext()) {
		        LeagueEntity league = i.next();
		        out.println("<li>" + league.getTitle() + "</li>");
		    }
		   } %>
    </ul>
    <br/><br/>
    
    <a href='index.html'>Home</a>
</body>
</html>
