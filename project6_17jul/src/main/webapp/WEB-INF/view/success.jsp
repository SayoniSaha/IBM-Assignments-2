<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Added League</title>
</head>
<body>

    <h2>Added Successfully</h2>
    <hr>
    <br/>
    <%@ page import="com.model.League" %>
    <% League league = (League) request.getAttribute("LEAGUE"); %>
    <% if (league != null) { %>
        <p>League year: <%= league.getYear() %></p>
        <p>League season: <%= league.getSeason() %></p>
        <p>League title: <%= league.getTitle() %></p>
    <% } %>
    <br/><br/>
    
    <a href='http://localhost:8080/project6_17jul'>Home</a>
</body>
</html>
