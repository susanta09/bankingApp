<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="img.css">
<link rel="stylesheet" href="body.css"> -->
<style>
input{
 background-color: green;
 color:menu;
 font-size: 20px;
 border: none;
 text-decoration: none;
 cursor:pointer;
border-radius: 8px;
 
}
</style>
</head>
<body>
	<div class="container">
		<div>
			<h1 style="margin: 0px;color: orange; font-size: 40px">YES BANK</h1>
			<h3 style="margin: 0px; color: maroon;">Flexible Banking Solutions</h3>
			<p>Lorem Ipsum is simply dummy text of the printing and
				typesetting industry. Lorem Ipsum has been the industry's standard
				dummy text ever since the 1500s, when an unknown printer took a
				galley of type and scrambled it to make a type specimen book. It has
				survived not only five centuries, but also the leap into electronic
				typesetting, and more recently with desktop publishing software like
				Aldus PageMaker including versions of Lorem Ipsum.</p>
		</div>
		<div >
			<table>
				<tr>
					<td>
						<form action="log">
							<input type="submit" value="Login">
						</form>
					</td>
					<td>
						<form action="regform">
							<input type="submit" value="Registration">
						</form>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div> 
	 <h1 style="color: red;text-align: center;">${message}</h1>
	</div>
</body>
</html>