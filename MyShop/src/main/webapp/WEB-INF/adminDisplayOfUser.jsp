<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
 h1{
  margin: 0px;
  color: fuchsia;
  font-size: 28px;
 }
 #d1{
 color: purple;
 }
 #d2{
 color: lime;
 }
 #d3{
 background-color: aqua;
    color: hsl(291deg 89% 33%);
    position: relative;
    left: 96px;
 }
 #d4{
 background-color: aqua;
    color: hsl(291deg 89% 33%);
    text-align: center;;
 }
 input {
	font-size: 22px;
}
.a {
	text-decoration: none;
	border:1px solid;
	padding: 2px 10px;
	margin-left: 4px;	
	background-color: 
}
.a1{
text-decoration: none;
padding: 2px 11px;
}
a:hover {
	background-color: aqua;
}
h1{
font-size: 20px;
}
</style>
</head>
<body>
<div>
<jsp:include page="adminNab.jsp"></jsp:include>
</div>
<div>
	  <form action="/MyShop/searchUserD/"  >
	    <input type="text" name="rid"  placeholder="Enter the Account number">
	    <button>Search</button>
	    <a class="a" href="/MyShop/userD">Refresh</a>
	  </form>
	</div>
<div>
<center>
			<table>
				<caption><h1 id="d4">Profile Details</h1></caption>
				<tr>
					<td><h1 id=d1>Registration Number:-</h1></td>
					<td><h1>${reg.rid }</h1></td>
				</tr>
				<tr>
					<td><h1 id=d1>Name:-</h1></td>
					<td><h1>${reg.fname}${reg.lname}</h1></td>

				</tr>
				<tr>
					<td><h1 id=d1>Gender:</h1></td>
					<td><h1>${reg.gender}</h1></td>
				</tr>
				<tr>
					<td><h1 id=d1>Nationality:</h1></td>
					<td><h1>${reg.nationality}</h1></td>
				</tr>
				<tr>
					<td><h1 id=d1>Date Of Birth:</h1></td>
					<td><h1>${reg.dob}</h1></td>
				</tr>
				<tr>
					<td><h1 id=d1>Fathers Name:</h1></td>
					<td><h1>${reg.fatherName}</h1></td>
				</tr>
				<tr>
					<td><h1 id=d1>Email Id:</h1></td>
					<td><h1>${reg.email}</h1></td>
				</tr>
				<tr>
					<td><h1 id=d1>Phone Number:</h1></td>
					<td><h1>${reg.phonNo}</h1></td>
				</tr>
				<tr><th><h1 id="d3">Address Details </h1><th></tr>
				<tr>
					<td><h1 id=d2>Pin Code Number:</h1></td>
					<td><h1>${add.pincode}</h1></td>
				</tr>
				<tr>
					<td><h1 id=d2>city Name:</h1></td>
					<td><h1>${add.city}</h1></td>
				</tr>
				<tr>
					<td><h1 id=d2>District:</h1></td>
					<td><h1>${add.dist}</h1></td>
				</tr>
				<tr>
					<td><h1 id=d2>State:</h1></td>
					<td><h1>${add.state}</h1></td>
				</tr>
				<tr>
					<td><h1 id=d2>country:</h1></td>
					<td><h1>${add.country}</h1></td>
				</tr>
			</table>
		</center>
</div>
<div>
  <a href="/MyShop/createAccount/${reg.rid}"><button>Create Account</button></a>
</div>
</body>
</html>