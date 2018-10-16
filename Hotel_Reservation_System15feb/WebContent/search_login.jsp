<html>
<head>
<meta http-equiv="content-type" content="text/xhtml; charset=utf-8" /> 
<link href="my.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/css/bootstrap.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.min.css">
<script src="jquery-3.2.1.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
 <script type="text/javascript">
    var datefield=document.createElement("input")
    datefield.setAttribute("type", "date")
    if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
        document.write('<link  href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel = "stylesheet">\n')
        document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
        document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n') 
    }
    

</script> 
<script>
if (datefield.type!="date"){ //if browser doesn't support input type="date", initialize date picker widget:
    jQuery(function($){ //on document.ready
        $('#check_date').datepicker({
        	changeMonth:true,
            changeYear:true,
            yearRange: "-1:+1",
            dateFormat: 'dd-MM-yy' ,
           
            
        });
    })
}
</script> 
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
<body>

<%
String customer_name=""; 
if(session.getAttribute("customer_name")!=null){
	customer_name=session.getAttribute("customer_name").toString();
}
%>
<%  
  response.setHeader("Cache-Control", "no-cache");  
  response.setHeader("Pragma", "no-cache");  
  response.setDateHeader("max-age", 0);  
  response.setDateHeader("Expires", 0);  
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
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
<div class="Home" style="margin-top:30px;margin-left:100px; font-size:20px;margin-bottom:30px;"><a href="login.jsp" style="">Home</a></div>

<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:50px; font-size:20px;margin-bottom:30px;"><a href="Cancellation.jsp" style="">Cancel Your Booking</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="AboutUs.jsp">About Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="ContactUs.jsp">Contact Us</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>

<div class="Home" style="margin-top:60px;margin-left:80px; font-size:20px;margin-bottom:30px;"><a href="logout.jsp" style="">LogOut</a></div>
</div>
</div>
<div class="col-md-9"style="height:900px;">

 <div style="margin-left:500px;"><span style="color:#f4ce42;"><b><%=customer_name %></b></span></div>


<div><center><h1>Feel Like Home-Away From Home</h1></center></div>
<div><br><h2>Book Your Stay With Us:<h2></div><br>

<table><tr>
<th><div>
<form action="SearchController" method="POST">
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

</tr></table>



<table><center><div><br><br>
  <input type="submit" value="Get Set Go!!" name="submit">
</div></center></table>
</form>




</div>
</div>
</div>
</div>
</div>
</body>