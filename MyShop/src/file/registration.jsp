<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="img.css">
<link rel="stylesheet" href="registration.css">
<style>
/* @media screen and (max-width: 786px) {
  container {
   
  }
} */
</style>
</head>
<body>
<div class="container">
		<div class="d1">
		<form action="">
			<table>
			 <caption><h1>Registration</h1></caption>
				<tr>
					<td><h2 style="color: orange;margin: 0px">User Name:</h2></td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td><h2 style="color: orange;margin: 0px">Email:</h2></td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td><h2 style="color: orange;margin: 0px">New Password:</h2></td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td><h2 style="color: orange;margin: 0px">Confirm Password:</h2></td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td><input type="text" value="fail" name="state" hidden=""></td>
				</tr>
				<tr>
					<td><input type="submit" value="Registration"></td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>