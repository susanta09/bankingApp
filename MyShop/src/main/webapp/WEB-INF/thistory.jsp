<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.collapsible {
  background-color: #777;
  color: white;
  cursor: pointer;
  padding: 18px;
  /* width: 100%; */
  style="float:right";
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
}

.active, .collapsible:hover {
  background-color: #555;
}

.content {
  padding: 0 18px;
  display: none;
  overflow: hidden;
  background-color: #f1f1f1;
}
</style>
</head>
<body>
<div><jsp:include page="nab.jsp"></jsp:include></div>

<%-- <div>
<button type="button" class="collapsible">Transaction Details</button>

<div class="content">
  <jsp:include page="profile.jsp"></jsp:include>

<a href="pagtran">hh</a>
</div>
</div> --%>

	<div>
		<a href="pagtran"><button type="button" class="collapsible">Transaction
				Details</button></a>
		<div class="content">
			<button type="button" class="collapsible">Transaction
				Details</button>
		</div>
	</div>


	<script>

var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}

</script>
</body>
</html>