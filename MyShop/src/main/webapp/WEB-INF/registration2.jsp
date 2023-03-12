<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Set"%>
<%@page import="com.bank.modal.Address2"%>
<%@page import="com.bank.modal.Registration2"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>

<script src="<c:url value="js/reg.js"/>"></script>
<style type="text/css">
.error{
color: red;
font-family: consolas;
font-style: italic;
font-weight: bold;
font-size: large;
}
 #id {
color: red;
font-size: 15px;
text-align: center;
   border-radius: 6px;

}
#nationality
{
color: red;
font-size: 15px;
text-align: center;
   border-radius: 6px;
}
#center{
 margin-left: auto;
 margin-right: auto;
 margin-top: auto;
 margin-top: auto;
 }
@media only screen and (min-width: 400px) {
  body {
    background-color: lightblue;
  }
  #id{
  font-size: 20px;
  }
  #nationality
  {
     font-size: 20px;
  }
  caption{
 font-size: 20px;
}
}
caption{
 font-size: 30px;
 font-style: inherit;
 text-decoration: underline;
 background-color: aqua;
}
table{
   margin-left: auto;
   margin-right: auto;
   background-color: silver;
   }
.sub{
    position: relative;
    left: 300px;
    color: #a20ebb;
    font-style: inherit;
    border-radius: 66px;
    font-size: 15px;
}
 #form{
  padding-top: 20px;
 }
</style>
</head>
<body>
<%-- <%
Registration r=(Registration)request.getAttribute("reg");
Set<Address> s=r.getAddress();
Object[] arr=s.toArray();
Address a=(Address)arr[0];
%> --%>
	<form:form action="rr" modelAttribute="reg" id="form">

		<table>
			<caption>Registration</caption>
			<tr>
				<td><form:label path="rid" id="id">Registration Id:</form:label></td>
				<td><form:input path="rid" id="id" value="${rid }" readonly="true"/></td>
				<td><font id="registE" style="color: red;"></font></td>

			</tr>

			<tr>
				<td><form:label path="fname" id="id">First Name:</form:label></td>
				<td><form:input path="fname" id="id" /></td>
				<td><font id="fnameE" style="color: red;"></font></td>
				<%-- <td><form:errors path="fname" cssClass="error" /></td> --%>
			</tr>

			<tr>
				<td><form:label path="lname" id="id">Last Name:</form:label></td>
				<td><form:input path="lname" id="id" /></td>
				<td><font id="lnameE" style="color: red;"></font></td>
				<%-- <td><form:errors path="lname" cssClass="error" /></td> --%>
			</tr>
			<tr>
				<td><form:label path="gender" id="id">Gender:</form:label></td>
				<td id="id">Male <form:radiobutton path="gender" value="Male"
						id="male" /> Female <form:radiobutton path="gender"
						value="Female" id="female" />
				</td>
				<td><font id="genderE" style="color: red;"></font></td>
				<%-- 	<td><form:errors path="gender" cssClass="error" /></td> --%>
			</tr>

			<tr>
				<td><form:label path="nationality" id="id">Nationality: </form:label></td>
				<td><form:select path="nationality" title="SUBJECT"
						multiple="fash" size="1" id="nationality">
						<form:option value="" label="Default null" id="id" />
						<form:option value="Indian" label="Indian" id="id" />
						<form:option value="American" label="American" id="id" />
						<form:option value="Canadian" label="Canadian" id="id" />
						<form:option value="Japanise" label="Japanise" id="id" />
						<form:option value="Rusian" label="Rusian" id="id" />
					</form:select></td>
				<td><font id="nationalityE" style="color: red;"></font></td>
			</tr>
			<tr>
				<td><form:label path="dob" id="id">Date Of Birth:</form:label></td>
				<td><form:input path="dob" id="id" /></td>
				<td><font id="dobE" style="color: red;"></font></td>

			</tr>

			<tr>
				<td><form:label path="fatherName" id="id">Father Name:</form:label></td>
				<td><form:input path="fatherName" id="id" /></td>
				<td><font id="fatherNameE" style="color: red;"></font></td>
			</tr>
			<tr>
				<td><form:label path="email" id="id">Email id:</form:label></td>
				<td><form:input path="email" id="id" /></td>
				<td><font id="emailE" style="color: red;"></font></td>
			</tr>
			<tr>
				<td><form:label path="phonNo" id="id">Phone Number:</form:label></td>
				<td><form:input path="phonNo" id="id" /></td>
				<td><font id="phonNoE" style="color: red;"></font></td>
			</tr>
			<tr>
				<td><h1 style="margin: 0px;">Address</h1></td>
			</tr>
			<form:form action="rr" modelAttribute="add">
				<tr>
					<td><form:label path="city" id="id">City Name:</form:label></td>
					<td><form:input path="city" id="id" /></td>
					<td><font id="cityE" style="color: red;"></font></td>
				</tr>
				<tr>
					<td><form:label path="pincode" id="id">Pin code Number:</form:label></td>
					<td><form:input path="pincode" id="id" /></td>
					<td><font id="pincodeE" style="color: red;"></font></td>
				</tr>
				<tr>
					<td><form:label path="dist" id="id">District Name:</form:label></td>
					<td><form:input path="dist" id="id" /></td>
					<td><font id="distE" style="color: red;"></font></td>
				</tr>
				<tr>
					<td><form:label path="state" id="id">State Name:</form:label></td>
					<td><form:input path="state" id="id" /></td>
					<td><font id="stateE" style="color: red;"></font></td>
				</tr>
				<tr>
					<td><form:label path="country" id="id">Country Name:</form:label></td>
					<td><form:input path="country" id="id" /></td>
					<td><font id="countryE" style="color: red;"></font></td>
				</tr>
				<tr>
					<td><input type="submit" onclick="return validate()"
						value="Submit" class="sub"></td>
				</tr>
			</form:form>

		</table>

	</form:form>
</body>
</html>