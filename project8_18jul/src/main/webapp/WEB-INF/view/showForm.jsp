<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
	<meta charset="ISO-8859-1">
	<title>Add employee</title>
</head>
<body>
    <h1>Add employee</h1>
    <hr/>

    <% String error = (String) request.getAttribute("error");
    if (error != null && !error.isEmpty()) { %>
        <p style="color: red"><%= error %></p>
    <% } %>

    <form action="addEmployee" method="post">
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="t1"></td>
            </tr>
            <tr>
                <td>Age: </td>
                <td><input type="number" name="t2"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Add Employee" class="btn btn-dark"></td>
            </tr>
        </table>
    </form>
</body>
</html>

