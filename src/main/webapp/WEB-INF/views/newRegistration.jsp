<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NewRegistration</title>
</head>
<body>
	<h2>New Registration Here...</h2>
	<form action="register" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city" /></td>
			</tr>
			<tr>
				<td>Email id:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Mobile no.</td>
				<td><input type="text" name="mobile" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form>
	<%
	if(request.getAttribute("msg")!=null){
		out.println(request.getAttribute("msg"));
	}
	%>

</body>
</html>