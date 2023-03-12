<style>
/* The sidepanel menu */
.sidepanel {
  height: 100%; /* Specify a height */
  width: 0; /* 0 width - change this with JavaScript */
  position: fixed; /* Stay in place */
  z-index: 1; /* Stay on top */
  top: 0;
  left: 0;
  background-color: #111; /* Black*/
  overflow-x: hidden; /* Disable horizontal scroll */
  padding-top: 60px; /* Place content 60px from the top */
  transition: 0.5s; /* 0.5 second transition effect to slide in the sidepanel */
}

/* The sidepanel links */
.sidepanel a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 2em;
  color: #818181;
  display: block;
  transition: 0.3s;
}

/* When you mouse over the navigation links, change their color */
.sidepanel a:hover {
  color: #f1f1f1;
}

/* Position and style the close button (top right corner) */
.sidepanel .closebtn {
     position: absolute;
    top: 0px;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

/* Style the button that is used to open the sidepanel */
.openbtn {
  font-size: 20px;
  cursor: pointer;
  background-color: #111;
  color: white;
  padding: 8px 15px;
  border: none;
}
h4{
    position: absolute;
    top: -40px;
    right: 125px;
    font-size: 36px;
    color: red;
}
.openbtn:hover {
  background-color: #444;
}
</style>
</head>
<body>

<div id="mySidepanel" class="sidepanel">
  <h4>Menu</h4>
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="/MyShop/depo">Deposit</a>
  <a href="/MyShop/with">Withdraw</a>
  <a href="/MyShop/trans">Transaction</a>
  <a href="#">Contact</a>
</div>

<!-- <a href="depo">depo</a>
<a href="with">with</a>
<a href="trans">tran</a> -->


<button class="openbtn" onclick="openNav()">&#9776;Operation</button>

<script>
/* Set the width of the sidebar to 250px (show it) */
function openNav() {
  document.getElementById("mySidepanel").style.width = "250px";
}

/* Set the width of the sidebar to 0 (hide it) */
function closeNav() {
  document.getElementById("mySidepanel").style.width = "0";
} 
</script>
   
</body>
</html> 
