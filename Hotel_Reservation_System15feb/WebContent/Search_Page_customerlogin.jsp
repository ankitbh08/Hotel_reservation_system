<html>
<head>
<meta http-equiv="content-type" content="text/xhtml; charset=utf-8" /> 
<link href="my.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/css/bootstrap.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.min.css">
<script src="jquery-3.2.1.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<style>
table {
    font-family: arial, sans-serif;
    width: 90%;
    border-collapse: collapse;
    margin-left:5%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding:8px;
	

}
.home a{color:white;width:15px;}
.home a:hover{
	
	color:#f4ce42;
}
</style>


<script type="text/javascript">
 //<![CDATA[ 
 // array of possible countries in the same order as they appear in the country selection list 
 var countryLists = new Array(4) 
 countryLists["empty"] = ["Select a Country"]; 
 countryLists["India"] = ["Mumbai", "Delhi", "Kolkata"]; 
  countryLists["Pakistan"] = ["Karachi", "Peshawar", "Islamabad"];
  countryLists["Australia"] = ["Sydney", "Adelaide", "melbourne"]; 
  countryLists["USA"] = ["New-York", "Bristol", "Miami"];
 /* CountryChange() is called from the onchange event of a select element. 
 * param selectObj - the select object which fired the on change event. 
 */ 
 function countryChange(selectObj) { 
 // get the index of the selected option 
 var idx = selectObj.selectedIndex; 
 // get the value of the selected option 
 var which = selectObj.options[idx].value; 
 // use the selected option value to retrieve the list of items from the countryLists array 
 cList = countryLists[which]; 
 // get the country select element via its known id 
 var cSelect = document.getElementById("country"); 
 // remove the current options from the country select 
 var len=cSelect.options.length; 
 while (cSelect.options.length > 0) { 
 cSelect.remove(0); 
 } 
 var newOption; 
 // create new options 
 for (var i=0; i<cList.length; i++) { 
 newOption = document.createElement("option"); 
 newOption.value = cList[i];  // assumes option string and value are the same 
 newOption.text=cList[i]; 
 // add the new option 
 try { 
 cSelect.add(newOption);  // this will fail in DOM browsers but is needed for IE 
 } 
 catch (e) { 
 cSelect.appendChild(newOption); 
 } 
 } 
 } 
//]]>
</script>



</head>
<%
if(session.getAttribute("username")==null)
  {
	  //response.sendRedirect("login.jsp");
	 RequestDispatcher view=request.getRequestDispatcher("login.jsp");
	 view.forward(request, response);
  }
  %> 
<%  
  response.setHeader("Cache-Control", "no-cache");  
  response.setHeader("Pragma", "no-cache");  
  response.setDateHeader("max-age", 0);  
  response.setDateHeader("Expires", 0);  
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
%>
<body>
<%

String message="";
if(request.getAttribute("message")!=null){
	   message=request.getAttribute("message").toString();
	   
}
 
%>
<div class="whole" style="background:url(img2.jpg) repeat;">
<div class="container">
<div class="row">
<div class="col-md-3" style="background:#3e3f42;height:900px;">
<div class="logo" style="margin-top:40px;margin-left:30px;">
<img src="logo.jpg" width=180px;height=180px;>
</div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="conatiner" id="left_nav">
<div class="Home" style="margin-top:30px;margin-left:100px; font-size:20px;margin-bottom:30px;"><a href="" style="">Home</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:50px; font-size:20px;margin-bottom:30px;"><a href="Cancellation.jsp" style="">Cancel Your Booking</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="AboutUs.jsp">About Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="ContactUs.jsp">Contact Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:60px; font-size:20px;margin-bottom:30px;"><a href="logout.jsp" style="">LogOut</a></div>
</div>
</div>
<div class="col-md-9"style="height:900px;">



<div><center><h1>Feel Like Home-Away From Home</h1></center></div>
<div><br><h2>Book Your Stay With Us:<h2></div><br>

<table><tr>
<th><div>
<form action="ReserveHotelController" method="POST">
   Country:<br>
  
  <select id="continent" onchange="countryChange(this);"name="country">
   <option value="empty">Select a Country</option>
    <option value="India">India</option>
 <option value="Pakistan">Pakistan</option>
 <option value="Australia">Australia</option>
  <option value="USA">USA</option>
  </select>
  
</div></th>


<th><div style="margin-top:-14px;">
   City:<br>
 
  <select id="country" name="city">
    <option value="0">Select a City</option>
  </select>
</div></th>

<th><div style="margin-top:-12px;">

  Hotel Name/Id:<br>
  <input type="text" name="hotel_name" value="">
</div></th>
</tr></table><br>


<table><tr>
<th><div>

   Check in Date:<br>
   <input type="date" name="checkin_date">

</div></th>

<th><div>

   Check out Date:<br>
   <input type="date" name="checkout_date">

</div></th>

<th><div>
   Room Type:<br>
  <input list="browsere" name="browsere">
  <datalist id="browsere" name="room_type">
    <option value="AC Room">
    <option value="Non AC Room">
  </datalist>
</div></th>
</tr></table><br>


<table><tr>
<th><div>
   Rooms:<br>
  <input list="browserss" name="browserss">
  <datalist id="browserss" name="no_of_rooms">
    <option value="1">
    <option value="2">
    <option value="3">
    <option value="4">
  </datalist>
</div></th>

<th><div style="margin-top:-20px;"><br>
   Adults:<br>
  <input list="browserse" name="browserse">
  <datalist id="browserse" name="no_of_adults">
    <option value="1">
    <option value="2">
    <option value="3">
    <option value="4">
  </datalist>
</div></th>

<th><div style="margin-top:-20px;"><br>
   Children:<br>
  <input list="browsersee" name="browsersee">
  <datalist id="browsersee" name="no_of_children">
    <option value="0">
    <option value="1">
    <option value="2">
    <option value="3">
    <option value="4">
  </datalist>
</div></th></tr></table>


 <div style="margin-top:-330px;margin-left:190px">
<span id="loginerror" style="font-weight:15px; text-decoration:underline;color:red" ><b><%=message %></b></span></div>
<table><center><div><br><br>
  
</div></center></table>
<div style="margin-top:300px;margin-left:370px"><input type="submit" value="Get Set Go!!" name="submit"></div>
</form>




</div>
</div>
</div>
</div>
</div>
</body>