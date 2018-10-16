<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="admin_add_hotel.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/css/bootstrap.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.min.css">


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
if(request.getAttribute("message")!=null){
	   message=request.getAttribute("message").toString();
	   id=request.getAttribute("hotel_id").toString();
	   country=request.getAttribute("country").toString();
	   city=request.getAttribute("city").toString();
	   non_ac_rooms=request.getAttribute("non_ac_rooms").toString();
	   ac_rooms=request.getAttribute("ac_rooms").toString();
	   name=request.getAttribute("hotel_name").toString();
	   description=request.getAttribute("description").toString();
}
if(request.getAttribute("success")!=null){
	success=request.getAttribute("success").toString();
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
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="AboutUs.jsp" style="">About Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="ContactUs.jsp" style="">Contact Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:30px; font-size:20px;margin-bottom:30px;"><a href="logout.jsp" style="">LogOut</a></div>
</div>
<div class="col-md-9"style="height:900px;">
<span style="font-size:25px;color:white;font-family:Trebuchet MS;"><b><%=message %></b></span>
<br>
<b><%=success %></b>
<form action="AdminController?bar=edited" method="POST">

<div>Hotel Id: <input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="hotel_id" type="text" value="<%=id %> " readonly></div>
<br>
<div>Hotel Name: <input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="hotel_id" type="text" value="<%=name %> " ></div>
<br>

<div> Description: <input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="description" type="text" value="<%=description %>"></div>
<br>
<div>Country: <input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="description" type="text" value="<%=country %>" readonly></div>
<br>

<div>City: <input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="description" type="text" value="<%=city %>" readonly></div>
<br>
<div> No of Ac Rooms: <input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="no_of_ac_rooms" type="text" value="<%=ac_rooms %>" ></div>
<br>
<div>No of Non Ac Rooms: <input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="no_non_ac_rooms" type="text" value="<%=non_ac_rooms %>" ></div>
<br>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="rate_ac_child" type="text" placeholder="Rate per night for Child in AC room(1000-2000)" required></div>
<br>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="rate_non_ac_child" type="text" placeholder="Rate per night for Child in non-AC room(2001-3000)" required></div>
<br>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="rate_ac_adult" type="text" placeholder="Rate per night for an Adult in AC room(2501-4000)" required></div>
<br>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="rate_non_ac_adult" type="text" placeholder="Rate per night for an Adult in AC room(2000-2500)" required></div>
<br>
<div><input type="submit" value="ADD HOTEL" class="btn btn-warning col-md-12" onclick="" required></div>
</div>
</div>
</form>
</div>
</div>
</body>
</html>