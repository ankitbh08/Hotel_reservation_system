 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="my.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/css/bootstrap.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="css/style.css">
<script src="jquery-3.2.1.js"></script>

<style>
.home a{color:white;width:15px;}
.home a:hover{
	
	color:#f4ce42;
}
#col_md_9_box{
background:;
height:1000px;
background-image:url(img2.jpg);
background-repeat:no-repeat;
font-family:Raleway, Open Sans, Droid Sans, Roboto,arial, sans-serif;
}

#col_md_9_box{
background:;
height:900px;
background-image:url(img2.jpg);
background-repeat:no-repeat;
font-family:Raleway, Open Sans, Droid Sans, Roboto,arial, sans-serif;
}
.detail_box{
background-color:#081428;
 opacity: 0.7;
    filter: alpha(opacity=50);
	height:110px;
	margin-top:10px;
	border-radius:15px 50px 30px;
}

.button {
  display: inline-block;
  border-radius: 20px;
  background-color: #d8c731;
  border: none;
  color: white;
  text-align: center;
  font-size: 20px;
  padding: 20px;
  width: 180px;
  /*height:40px;*/
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  height:50px;
}

#button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

#button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

#button:hover span {
  padding-right: 25px;
}

#button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>

</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*,com.hrs.to.HotelSearchTO"%>
<%  
  response.setHeader("Cache-Control", "no-cache");  
  response.setHeader("Pragma", "no-cache");  
  response.setDateHeader("max-age", 0);  
  response.setDateHeader("Expires", 0);  
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
%>
<%

List<HotelSearchTO> hList=new ArrayList<HotelSearchTO>();
String message="";
hList = (List<HotelSearchTO>)request.getAttribute("hotelList");
if(request.getAttribute("message")!=null){
	   message=request.getAttribute("message").toString();
	  }

session.setAttribute("hotel_list",hList);

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
<div class="Home" style="margin-top:30px;margin-left:100px; font-size:20px;margin-bottom:30px;"><a href="" style="">Home</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:60px; font-size:20px;margin-bottom:30px;"><a href="Search Page_withoutlogin.html" style="">Search Hotels</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="AboutUs.jsp" style="">About Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="ContactUs.jsp" style="">Contact Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:50px; font-size:20px;margin-bottom:30px;"><a href="Cancellation.jsp" style="">Cancel Your Booking</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:20px;margin-left:100px; font-size:20px;margin-bottom:30px;"><a href="logout.jsp" style="">Logout</a></div>
</div>

</div>
<div class="col-md-9" id ="col_md_9_box"style="">

 <div style="margin-left:500px;"><span style="color:#f4ce42;"><b><%=session.getAttribute("customer_name") %></b></span></div>

<div class="for_loop_carrier" style="margin-top:30px">
<%int i=0; %>
  <% for (HotelSearchTO hotels:hList) {   
%>
<form action="BookingController" method="POST">  
<div class="detail_box" style="color:white">

                    <div class="hotel_name" style="margin-top:5px;margin-left:10px;font-family:Courier New;font-size:30px"><b><%=hotels.getHotel_name() %></b></div>
                     <div style="margin-top:-30px;margin-left:600px;"><button class="button" type="submit" name="book_selection" value="<%=i %>" style="vertical-align:middle"><span style="margin-top:;font-family:Trebuchet MS;">BOOK NOW !!</span></button></div>
                    <div class="hotel_derscription" style="font-size:20px;margin-left:20px;margin-top:2px;font-family:Trebuchet MS;"><%=hotels.getDescription() %></div>
                    
                    <div style="margin-left:600px;font-size:20px;margin-top:-40px;font-family:Trebuchet MS;"><span style="font-family:Trebuchet MS;">&#x20B9 RS</span><%=hotels.getRate_adult_per_night_AC() %></div>
                   
                    <%i++; %>
                

</div>
           <%}%>
        </form>

   </div>


   </div>


</div>
</div>
</div>



</body>
</html>