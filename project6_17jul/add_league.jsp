
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

	<form action="add_league.do" method="POST">
		Year: <input type="text" name='year' /> <br /><br />
		Season: <select name="season">
			<option value="UNKNOWN">Select-</option>
			<option value="Spring">Spring</option>
			<option value="Summer">Summer</option>
			<option value="Fall">Monsoon</option>
			<option value="Winter">Winter</option>
		</select> <br /><br />
		Title: <input type='text' name="title" /> <br /><br />
		<input type="submit" value="Add League" />
	</form>
</body>

</html>
