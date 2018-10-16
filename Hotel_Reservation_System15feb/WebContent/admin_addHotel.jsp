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
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="search_admin.jsp" style="">Delete Hotel</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="search_admin.jsp" style="">Edit Hotel</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="AboutUs.jsp" style="">About Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="ContactUs.jsp" style="">Contact Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:30px; font-size:20px;margin-bottom:30px;"><a href="logout.jsp" style="">LogOut</a></div>

</div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
</div>
<div class="col-md-9"style="height:900px;">
<h1 align="center" colour:red>ADD HOTEL</h1>
<span style="font-size:25px;color:white;font-family:Trebuchet MS;"><b><%=message %></b></span>
<br>
<form action="AdminController?bar=add" method="POST">
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="hotel_id" type="text" placeholder="Hotel id" required></div>
<br>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="hotel_name" type="text" placeholder="Hotel Name" required></div>
<br>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="description" type="text" placeholder="description" required></div>
<br>
<div><div class="menu-wrap" style="border-radius:5px;">
    <nav class="menu">
        <ul class="clearfix">
            
            <li>
                
 
                <select id="continent" onchange="countryChange(this);" name="country">
   <option value="empty">Select a Country</option>
    <option value="India">India</option>
 <option value="Pakistan">Pakistan</option>
 <option value="Australia">Australia</option>
  <option value="USA">USA</option>
  </select>
            </li>
</ul></nav></div>
<br>
<div><div class="menu-wrap" style="border-radius:5px;">
    <nav class="menu">
        <ul class="clearfix">
            
            <li>
                
 
               <select id="country" name="city">
    <option value="0">Select a City</option>
  </select>
            </li>
</ul></nav></div>
<br>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="no_of_ac_rooms" type="text" placeholder="Number of AC rooms" required></div>
<br>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="no_non_ac_rooms" type="text" placeholder="Number of non AC rooms" required></div>
<br>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="rate_ac_child" type="text" placeholder="Rate per night for Child in AC room(1000-2000)" required></div>
<br>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="rate_non_ac_child" type="text" placeholder="Rate per night for Child in non-AC room(2001-3000)" required></div>
<br>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="rate_ac_adult" type="text" placeholder="Rate per night for an Adult in AC room(2501-4000)" required></div>
<br>
<div><input class="form-control" data-required="true" id="id_yourname" maxlength="20" name="rate_non_ac_adult" type="text" placeholder="Rate per night for an Adult in AC room(2000-2500)" required></div>
<br>
<div><input type="submit" value="ADD HOTEL" class="btn btn-warning col-md-12" onclick=""></div>
</div>
</div>
</form>
</div>
</div>
</body>
</html>