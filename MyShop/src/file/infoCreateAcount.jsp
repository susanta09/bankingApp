<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form>
		<center>
			<table>
				<tr>
				 <td>First Name:</td>
				 <td><form:input path="fname"/></td>
				</tr>
				<tr>
				 <td>Last Name:</td>
				 <td><form:input path="lname"/></td>
				</tr>
				<tr>
				 <td>First Name:</td>
				 <td><form:input path="fname"/></td>
				</tr>
			</table>
		</center>
	</form:form>
</body>
</html>