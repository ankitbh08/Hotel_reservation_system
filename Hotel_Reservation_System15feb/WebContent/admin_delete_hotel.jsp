<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link href="my.css" rel="stylesheet" type="text/css" />
<link href="admin_add_hotel.css" rel="stylesheet" type="text/css" />
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
String message="";
String id="";
String country="";
String city="";
String ac_rooms="";
String non_ac_rooms="";
String name="";
String description="";
String success="";
HttpSession session1=request.getSession();  
if(request.getAttribute("success")!=null){
	success=request.getAttribute("success").toString();
}
if(request.getAttribute("message")!=null){
	   message=request.getAttribute("message").toString();
	   id=request.getAttribute("hotel_id").toString();
	   country=request.getAttribute("country").toString();
	   city=request.getAttribute("city").toString();
	   non_ac_rooms=request.getAttribute("non_ac_rooms").toString();
	   ac_rooms=request.getAttribute("ac_rooms").toString();
	   name=request.getAttribute("hotel_name").toString();
	   description=request.getAttribute("description").toString();
	   session1.setAttribute("id_of_hotel", id);
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
<div class="Home" style="margin-top:30px;margin-left:100px; font-size:20px;margin-bottom:30px;"><a href="login.jsp" style="">Home</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:60px; font-size:20px;margin-bottom:30px;"><a href="Search Page_withoutlogin.html" style="">Search Hotels</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="AboutUs.jsp" style="">About Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="ContactUs.jsp" style="">Contact Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:30px; font-size:20px;margin-bottom:30px;"><a href="logout.jsp" style="">LogOut</a></div>
</div>

</div>
<div class="col-md-9" id ="col_md_9_box"style="">
<div class="for_loop_carrier" style="margin-top:40px">
<div class="detail_box" style="color:white">
<div class="text_line" style="margin-left:20px;">
<span>Hotel id : <%=id %></span>
<br>
<br>
<span>Hotel Name : <%=name %></span>
<br>
<br>
<span>Country : <%=country %></span>
<br>
<br>
<span>City : <%=city %></span>
<br>
<br>
<span>Description : <%=description %></span>
<br>
<br>
<form method="POST">
<div style="margin-left:-20px; margin-top:60px;"><button type="submit" class="btn btn-warning col-md-12" formaction="AdminController?bar=deleted">Delete hotel</button></div>
</form>
</div>
</div>

   </div>
</div>

</div>
</div>
</div>

</body>
</html>