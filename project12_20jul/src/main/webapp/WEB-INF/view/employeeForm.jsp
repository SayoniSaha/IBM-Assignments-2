<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
			Name: <form:input path="name" />
	
		<br><br>
			Country: <form:select path="country" title="COUNTRY" multiple="false"
                        size="3">
                        <form:option value="India" label="Java Programming" />
                        <form:option value="Germany" label="SQL language" />
                        <form:option value="Britain" label="Python programming" />
                        <form:option value="JavaScript" label="JavaScript" />
                    </form:select>

	
		<br><br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>