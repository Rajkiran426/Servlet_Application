<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateRegistration</title>
</head>
<body>
	<h2>Update Registration</h2>

	<form action="update" method="post">
		<table>
			<tr>
				<td>Email id:</td>
				<td><input type="text" name="email"	value="<%=request.getAttribute("email")%>" /></td>
			</tr>
			<tr>
				<td>Mobile:</td>	
				<td><input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form>
	

</body>
</html>