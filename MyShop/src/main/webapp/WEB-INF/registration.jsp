<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="img.css">
<link rel="stylesheet" href="registration.css"> -->
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
		<form:form action="ok" modelAttribute="reg">
		<table>
			 <caption><h1>Registration</h1></caption>
				<tr>
					<td><h2 style="color: orange;margin: 0px">User Name:</h2></td>
					<td><form:input path="userName"/></td>
				</tr>
				
				<tr>
					<td><h2 style="color: orange;margin: 0px">Create Password:</h2></td>
					<td><form:input path="password"/></td>
				</tr>
				<tr>
					<td><h2 style="color: orange;margin: 0px">Email:</h2></td>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<td><form:label path="userType">AccountType:</form:label></td>
					<td><form:select path="userType" size="1" multiple="false">
							<form:option value="admin" label="Admin" />
							<form:option value="nuser" label="N_user" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:hidden path="state" value="fail"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Registration"></td>
				</tr>
			</table>
		</form:form>
		</div>
	</div>
</body>
</html>