<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Locale"%>


<html>
<head>
<link href="admin_add_hotel.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/css/bootstrap.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.min.css">
<script src="jquery-3.2.1.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" src="RegisterValidation.js"></script>

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
<body>
<%  
  response.setHeader("Cache-Control", "no-cache");  
  response.setHeader("Pragma", "no-cache");  
  response.setDateHeader("max-age", 0);  
  response.setDateHeader("Expires", 0);  
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
%>
<%

String message="";
if(request.getAttribute("message")!=null){
	   message=request.getAttribute("message").toString();
	   
}
session.invalidate(); 
%>
	

<div class="whole" style="background:url(img2.jpg) repeat;">
<div class="container">
<div class="row">
<div class="col-md-3" style="background:#3e3f42;height:900px;">
<div class="logo" style="margin-top:40px;margin-left:30px;">
<img src="logo.jpg" width=180px;height=180px;>
</div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:30px;margin-left:100px; font-size:20px;margin-bottom:30px;"><a href="login.jsp" style="">Home</a></div>

<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:30px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="AboutUs.jsp">About Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:30px;margin-left:70px; font-size:20px;margin-bottom:30px;"><a href="ContactUs.jsp">Contact Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>


</div>
<div class="col-md-9"style="height:900px;">
<h1 align="center" colour:black;><b><i>REGISTER YOURSELF!!!</i></b></h1>

<span id="loginerror" style="font-weight:15px; text-decoration:underline;color:red" ><b><%=message %></b></span>

<form name="f1" action="CustomerController" method="post">
<br>
<b><p>Enter Name:(Alphabets only)</p></b>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="name" type="text" placeholder="Enter Name" pattern="[a-zA-Z\s]{1,20}" required></div>
<br>
<b><p>Enter Password:</p></b>
<div><input class="form-control" data-required="true" id="password" maxlength="20" name="password" type="password" placeholder="Password" onChange="return checkPassword()" required></div>
<br>
<b><p>Confirm Password:</p></b>
<div><input class="form-control" data-required="true" id="confirm_password" maxlength="20" onChange="return Validate()" name="confirm_password" type="password" placeholder="Confirm Password" required></div>
<br>
<b><p>Enter Date of birth(DD-MM-YYYY):</p></b>
<div><input class="form-control" data-required="true" id="dob" maxlength="20" name="date_of_birth" type="date" placeholder="Enter Date of Birth:" onchange="TDate()" required></div>
<br>
<b><p>Enter Contact Number:</p></b>
<div><input class="form-control" data-required="true" id="contact" maxlength="10" name="contact_number" type="text" placeholder="Contact Number"  pattern="[1-9]{1}[0-9]{9}" required></div>
<br>
<b><p>Enter Email Id:</p></b>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="email_address" type="email" placeholder="Email Address" required></div>
<br>
<b><p>Select Your Country:</p></b>
<div><div class="menu-wrap" style="border-radius:5px;">
    
    <nav class="menu">
        <ul class="clearfix">
            
            <select id="continent" onchange="countryChange(this);" name="country">
   <option value="empty">Select a Country</option>
    <option value="India">India</option>
 <option value="Pakistan">Pakistan</option>
 <option value="Australia">Australia</option>
  <option value="USA">USA</option>
  </select>
</ul></nav></div>

<b><p>Select Your City:</p></b>
<div><div class="menu-wrap" style="border-radius:5px;">
    <nav class="menu">
        <ul class="clearfix">
            
            <select id="country" name="city">
    <option value="0">Select a City</option>
  </select>
</ul></nav></div>
<b><p>Enter Pin Code:</p></b>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="6" name="pin" type="text" placeholder="Pin COde" required></div>
<br>

<div><input type="submit" value="Register Now" class="btn btn-warning col-md-12"/></div>
</form>
</div>
</div>
</div>
</div>

</body>