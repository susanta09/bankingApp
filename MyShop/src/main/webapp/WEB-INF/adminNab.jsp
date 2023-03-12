<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body{
margin: 0px;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333; 
}

li {
  float: left;
}

li a {
 font-size:20px;
  display: block;
  color: white;
  padding: 10px 15px;
  text-decoration: none; 
  
  

 
}

li a:hover:not(.active) {
  background-color: #111;
}

.active{
  background-color: #04AA6D;
}
</style>

</head>
<body>
<div>
<ul>
  <li><a href="/MyShop/admin">SAccount</a></li>
  <li><a href="/MyShop/pay">SPayment</a></li>
  <li><a href="/MyShop/searchT">STransaction</a></li>
  <li><a href="/MyShop/userD">CreateAccount</a></li>
  <li style="float:right"><a class="active" href="/MyShop/" >Logout</a></li>
  
</ul>
</div>
<div>
 <h1>${message}</h1>
</div>

</body>
</html>


