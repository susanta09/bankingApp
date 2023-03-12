<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="img.css">
<link rel="stylesheet" href="login.css">
</head>
<body>
	<div class="container">
		<div class="d1">
		<form action="login">
				<table>
					<caption>
						<h1>Login</h1>
					</caption>
					<tr>
						<td><h2 style="color: orange; margin: 0px">User Name:</h2></td>
						<td><input type="text" name="userName"></td>
					</tr>
					<tr>
						<td><h2 style="color: orange; margin: 0px">Password:</h2></td>
						<td><input type="text" name="password"></td>
					</tr>
					<tr>
						<td><h2 style="color: orange; margin: 0px">User Type:</h2></td>
						<td><select name="userType">
								<option value="admin">Admin</option>
								<option value="n_user">N_User</option>
						</select></td>
					</tr>
					<tr>
						<td><input type="submit" value="Login"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>