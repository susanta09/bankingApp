<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<jsp:include page="nab.jsp"></jsp:include>
</div>
<button onclick="gotoLink()">Profile</button>
<div id="myDIV">
<a href="http://localhost:8050/MyShop/collesp.jsp">XXXX</a>
</div>

<script>

	function gotoLink() {
		var x = document.getElementById("myDIV");
		if (x.style.display === "none") {
			x.style.display = "block"
		} else {
			x.style.display = "none";
		}

	}
</script>
</body>
</html>