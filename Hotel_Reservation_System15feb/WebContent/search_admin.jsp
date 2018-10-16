



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Search Hotel</title>
<link href="my.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/css/bootstrap.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.min.css">
<style>

form.example input[type=text] {
    
    box-sizing: border-box;
   
    border-radius: 4px;
    font-size: 16px;
    background-color: transparent;
padding: 10px;
    font-size: 17px;
    border: 1px solid grey;
    float: left;
    width: 80%;
    
}

form.example button {
    float: left;
    width: 10%;
    padding: 10px;
    background: #f4ce42;
    color: white;
    font-size: 17px;
    border: 1px solid grey;
    border-left: none;
    cursor: pointer;
}

form.example button:hover {
   border: 3px solid #555;
background:#ddb725;
}

form.example::after {
    content: "";
    clear: both;
    display: table;
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
if(request.getAttribute("message")!=null){
message=(String)request.getAttribute("message");
}
%>
<div class="whole" style="background:url(img2.jpg) repeat;">
<div class="container">
<div class="row">
<div class="col-md-3" style="background:#3e3f42;height:800px;">
<div class="logo" style="margin-top:40px;margin-left:30px;">
<img src="logo.jpg" width=180px;height=180px;>
</div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="add_hotel" style="margin-top:60px;margin-bottom:20px;margin-left:95px;font-size:20px;"><a href="admin_addHotel.jsp">Add Hotel</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="AboutUs.jsp">About Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="ContactUs.jsp">Contact Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
</div>
<div class="col-md-9"style="height:800px;">
<div class="search_tag">
<!-- <hr>

<hr> -->
<br><br>
<span><h3><b>ENTER THE HOTEL ID:</b></h3></span>
<!-- <hr><hr><hr> -->
</div>
<div style="text-align:center;text-size:100px;margin-top:70px">
<form class="example" method="POST">
  <input type="text" placeholder="Search.." name="hotel_id" required>
  
  
  

 <br><br>


 
 <div style="margin-top:40px;margin-left:-425px;  class="edit">
 
      <input type="submit" formaction="AdminController?bar=edit" value=" Edit Hotel "></div> 
      
      
<!--   <button type="submit"  formaction="AdminController?bar=edit"><i class="fa fa-search"></i>Edit Hotel</button>
 --> 
 
 <div style="margin-top:-27px;margin-left:80px; class="delete_">
 
      <input type="submit" formaction="AdminController?bar=delete" value=" Delete hotel " class="button CardGood" ></div> 
      
<!--  <button type="submit" formaction="AdminController?bar=delete">Delete hotel</button>
 -->
</form>
</div>

<span style="color:white"><b><%=message %><b></b></span>
 

</div>
</div>
</div>
</body>
</html>


















<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Search Hotel</title>
<link href="my.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/css/bootstrap.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.min.css">
<style>

form.example input[type=text] {
    
    box-sizing: border-box;
   
    border-radius: 4px;
    font-size: 16px;
    background-color: transparent;
	 padding: 10px;
    font-size: 17px;
    border: 1px solid grey;
    float: left;
    width: 80%;
    
}

form.example button {
    float: left;
    width: 10%;
    padding: 10px;
    background: #f4ce42;
    color: white;
    font-size: 17px;
    border: 1px solid grey;
    border-left: none;
    cursor: pointer;
}

form.example button:hover {
   border: 3px solid #555;
	background:#ddb725;
}

form.example::after {
    content: "";
    clear: both;
    display: table;
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
if(request.getAttribute("message")!=null){
	message=(String)request.getAttribute("message");
}
%>
<div class="whole" style="background:url(img2.jpg) repeat;">
<div class="container">
<div class="row">
<div class="col-md-3" style="background:#3e3f42;height:800px;">
<div class="logo" style="margin-top:40px;margin-left:30px;">
<img src="logo.jpg" width=180px;height=180px;>
</div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="add_hotel" style="margin-top:20px;margin-bottom:20px;margin-left:95px;"><a href="admin_addHotel.jsp">ADD HOTEL</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="AboutUs.jsp">About Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="ContactUs.jsp">Contact Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
</div>
<div class="col-md-9"style="height:800px;">
<div class="search_tag">

<br><br>
<span><h3><b>ENTER THE HOTEL ID:</b></h3></span>

</div>
<div style="text-align:center;text-size:100px;margin-top:70px">
<form class="example" method="POST">
  <input type="text" placeholder="Search.." name="hotel_id">
 
  <button type="submit"  formaction="AdminController?bar=edit"><i class="fa fa-search"></i>Edit Hotel</button>
 <button type="submit" formaction="AdminController?bar=delete">Delete hotel</button>

</form>
</div>

<span style="color:white"><b><%=message %><b></b></span>
 

</div>
</div>
</div>
</body>
</html> --%>