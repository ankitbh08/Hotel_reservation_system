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

String message="";
if(request.getAttribute("message")!=null){
	   message=request.getAttribute("message").toString();
	   
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
<div class="Home" style="margin-top:30px;margin-left:100px; font-size:20px;margin-bottom:30px;"><a href="login.jsp">Home</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:60px; font-size:20px;margin-bottom:30px;"><a href="Search Page_withoutlogin.jsp">Search Hotels</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="AboutUs.jsp">About Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="ContactUs.jsp">Contact Us</a></div>

</div>

</div>
<div class="col-md-9"style="background:;height:800px;background-image:url(img2.jpg);">
<div style="margin-top:100px;margin-left:20px;">
<h1 >
	
      <font color="green">Our goal is to change the way people stay away from home </font> </h1>
	<h3>We are India's one of the largest hotel network spread across the globe with all the hotels offering standardized and hassle-free stay experiences at an unmatched price.</h3>
 </div>
  
   </div>
   </div>


</div>
</div>
</div>
</div>
</div>
</body>
</html>