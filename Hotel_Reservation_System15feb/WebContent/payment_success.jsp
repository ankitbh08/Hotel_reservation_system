<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Locale"%>

<html>
<head>
<link href="my.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/css/bootstrap.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="css/style.css">
<script src="jquery-3.2.1.js"></script>
<script>
$("#slideshow > div:gt(0)").hide();

setInterval(function() {
  $('#slideshow > div:first')
    .fadeOut(1000)
    .next()
    .fadeIn(1000)
	
    .end()
    .appendTo('#slideshow');
}, 3000);

</script>
<style>
.home a{color:white;width:15px;}
.home a:hover{
	
	color:#f4ce42;
}
</style>
</head>
<body>
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
<%  
  response.setHeader("Cache-Control", "no-cache");  
  response.setHeader("Pragma", "no-cache");  
  response.setDateHeader("max-age", 0);  
  response.setDateHeader("Expires", 0);  
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
%>
<%

String message1="";
String username="";
String booking_id="";
String payment_id="";
if(message1!=null){
	message1=session.getAttribute("message1").toString();
	username=session.getAttribute("username").toString();
	booking_id=session.getAttribute("booking_id").toString();
	payment_id=session.getAttribute("payment_id").toString(); 
}


%>
	 
	


<div class="whole" style="background-color:#777f41;">
<div class="container">

<div class="row">
<div class="col-md-3" style="background:#3e3f42;height:1000px;">
<div class="logo" style="margin-top:40px;margin-left:30px;">
<img src="logo.jpg" width=180px;height=180px;>
</div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>

<div class="conatiner" id="left_nav">
<div class="Home" style="margin-top:30px;margin-left:100px; font-size:20px;margin-bottom:30px;"><a href="">Home</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:60px; font-size:20px;margin-bottom:30px;"><a href="Search Page_withoutlogin.html">Search Hotels</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="AboutUs.html">About Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="ContactUs.html">Contact Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:50px; font-size:20px;margin-bottom:30px;"><a href="Cancellation.jsp" style="">Cancel Your Booking</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:30px; font-size:20px;margin-bottom:30px;"><a href="logout.jsp" style="">LogOut</a></div>
</div>

</div>
<div class="col-md-9"style="background:;height:1000px;background-image:url(img2.jpg);">

<div style="text-align:center; margin-top:50px;">
   <div style="margin-left:500px;"><span style="color:#f4ce42;"><b><%=session.getAttribute("customer_name") %></b></span></div>
  
      
      
<span  style="font-weight:15px; text-decoration:underline;color:red" ><b><%="Congratulations!!! "+username+" "+message1 %></b></span>

<span style="font-weight:15px; text-decoration:underline;color:red" ><h3>booking id is:</h3><b><%=booking_id %></b></span>

<span  style="font-weight:15px; text-decoration:underline;color:red" ><h3>transaction id is:</h3><b><%=payment_id %></b></span>
	  
  
    

  




</div>
</div>

</body>
</html>