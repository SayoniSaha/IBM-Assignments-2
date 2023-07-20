<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Add League</title>
</head>

<body>


<%

	List<String> list=(List<String>)request.getAttribute("ERROR");

if(list!=null) {
	for(String str:list)
	out.println("<font color='blue'>"+str+"</font><br/>");
}

%>
	<p>
		New Soccer league form
	</p>

	<form:form action="success" modelAttribute="league">
		Year: <form:input path="year"/> <br /><br />
		Season: <form:select path="country" title="COUNTRY" multiple="false"
                        size="3">
                        <form:option value="India" label="Java Programming" />
                        <form:option value="Germany" label="SQL language" />
                        <form:option value="Britain" label="Python programming" />
                        <form:option value="JavaScript" label="JavaScript" />
                    </form:select> <br /><br />
		Title: <form:input path="title"/> <br /><br />
		<input type="submit" value="Add League" />
	</form:form>
</body>

</html>