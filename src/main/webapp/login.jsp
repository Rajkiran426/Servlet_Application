<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login here...</h2>
	
	<%
	if (request.getAttribute("error") != null) {
		out.println(request.getAttribute("error"));
	}
	%>

		<form action="vefiryLogin" method="post">
		
			<table>
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="pass" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" /></td>
				</tr>
			</table>
		</form>

</body>
</html>