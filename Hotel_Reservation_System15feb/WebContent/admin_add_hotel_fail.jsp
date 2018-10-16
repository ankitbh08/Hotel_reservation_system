<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link href="my.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/css/bootstrap.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans'>

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
#col_md_9_box{
background:;
height:800px;
background-image:url(img2.jpg);
background-repeat:no-repeat;
font-family:Raleway, Open Sans, Droid Sans, Roboto,arial, sans-serif;
}
.detail_box{
background-color:#081428;
 opacity: 0.7;
    filter: alpha(opacity=50);
	height:600px;
	width:600px;
	margin-top:60px;
	margin-left:100px;
	border-radius:15px 50px 30px;
	font-size:30px;
	font-family:Trebuchet MS;
}


</style>
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
if(session.getAttribute("username")==null)
  {
	  //response.sendRedirect("login.jsp");
	 RequestDispatcher view=request.getRequestDispatcher("login.jsp");
	 view.forward(request, response);
  }
  %> 


<div class="whole" style="background-color:#777f41;">
<div class="container">

<div class="row">
<div class="col-md-3" style="background:#3e3f42;height:800px;">
<div class="logo" style="margin-top:40px;margin-left:30px;">
<img src="logo.jpg" width=180px;height=180px;>
</div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>

<div class="conatiner" id="left_nav">
<div class="Home" style="margin-top:30px;margin-left:100px; font-size:20px;margin-bottom:30px;"><a href="" style="">Home</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:60px; font-size:20px;margin-bottom:30px;"><a href="Search Page_withoutlogin.html" style="">Search Hotels</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="AboutUs.jsp" style="">About Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="ContactUs.html" style="">Contact Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:30px; font-size:20px;margin-bottom:30px;"><a href="logout.jsp" style="">LogOut</a></div>
</div>

</div>
<div class="col-md-9" id ="col_md_9_box"style="">
<div class="for_loop_carrier" style="margin-top:40px">
<div class="detail_box" style="color:white">
<div class="text_line">
<span style="margin-left:30px;margin-top:50px;font-size:25px;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspUnable to add Hotel</span>
<br>
<br>
<span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbspClick To go back to Add Hotel Again</span>
<form action="admin_addHotel.jsp">
<div style="margin-left:270px; margin-top:200px;"><input type="submit" value="GO BACK TO ADD HOTEL" class="btn btn-warning col-md-12" onclick="" required></div>
</form>
</div>
</div>

   </div>
</div>

</div>
</div>
</div>


</body>