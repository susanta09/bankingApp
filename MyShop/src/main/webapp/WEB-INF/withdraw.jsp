<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
	position: relative;
	top: 25px;
	left: 260px;
}
</style>
</head>
<body>
<div><jsp:include page="nab.jsp"></jsp:include></div>
<div>
<form:form action="sub" modelAttribute="tr">
			<table>
			<caption><h1>Withdraw</h1></caption>
				<tr>
					<td><form:label path="accountNoFrom">AccountNo:</form:label></td>
					<td><form:input path="accountNoFrom"/></td>
				</tr>
				<tr>
					<td><form:label path="accountType">AccountType:</form:label></td>
					<td><form:select path="accountType" size="1" multiple="false">
					<form:option value="saving" label="Saving"/>
					<form:option value="busnees" label="busnees"/>
					</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="tAmount">Amount:</form:label></td>
					<td><form:input path="tAmount"/></td>
				</tr>
				<tr>
				<td><form:hidden path="paymentType" value="withdraw"/></td>
				</tr>
				<tr>
				<td><form:hidden path="sources" value="online"/></td>
				</tr>
				<tr>
				<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form:form>
</div>
</body>
</html>