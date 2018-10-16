<html>
<heaad>
<link href="my.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/css/bootstrap.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="font_awesome/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css1/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" src="Payment_validation.js"></script>
</head>
<body>
<div class="whole" style="background:url(img2.jpg) repeat;">
<div class="container">
<div class="row">
<div class="col-md-3" style="background:#3e3f42;height:1000px;">
<div class="logo" style="margin-top:40px;margin-left:30px;">
<img src="logo.jpg" width=180px;height=180px;>
</div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>

<div class="conatiner" id="left_nav">
<div class="Home" style="margin-top:60px;margin-left:100px; font-size:20px;margin-bottom:30px;"><a href="Search Page_cutomerlogin.html" style="">Home</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:50px; font-size:20px;margin-bottom:30px;"><a href="" style="">Edit Your Booking</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:30px; font-size:20px;margin-bottom:30px;"><a href="" style="">Cancel Your Booking</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:50px; font-size:20px;margin-bottom:30px;"><a href="Cancellation.jsp" style="">Cancel Your Booking</a></div>
<div class="line" style="margin-top:20px;"><img src="line.jpg" width=250px;height=240px;></div>
<div class="Home" style="margin-top:60px;margin-left:30px; font-size:20px;margin-bottom:30px;"><a href="logout.jsp" style="">LogOut</a></div>
</div>

</div>
<div class="col-md-9"style="height:1000px;">
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
<h1 style="text-align:cen ter;font-size:300%;"> MAKE YOUR PAYMENT </h1>

  <div class="card-container">
  <div class="card-wrapper"></div>

  <div class="form-container">
    <form action="PaymentController" name="paymentform" method="post">
  <table><tr><td>
  <div style="float:left;">
    <div style="margin-top:5px;"><input type="radio" id="contactChoice1"
     name="contact" value="visa"></div>
    <div style="float:left;margin-right:10px;"><label for="contactChoice1">visa</label></div>
</div><div style="float:left">
      <div style="margin-top:5px;"><input type="radio" id="contactChoice2"
     name="contact" value="master_card"></div>
     <div style="float:left;margin-right:10px;"><label for="contactChoice2">master_card</label></div>
</div><div style="float:left">
      <div style="margin-top:5px;"><input type="radio" id="contactChoice3"
     name="contact" value="others"></div>
     <div style="float:left;margin-left:10px;"><label for="contactChoice3">others</label></div>
  </div>
  </td></tr></table>
      <label for="number">Card Number(16 Digit)</label>
      <input placeholder="XXXX  XXXX  XXXX  XXXX" type="text" name="number" id="card_number" pattern="[0-9]+{16}" required>
      <label for="name">Name on Card(Alphabet only)</label>
      <input placeholder="Full Name" type="text" name="fullname" id="name" required><br> 
       <label for="number">Account Number(8 Digits)</label>
      <input placeholder="XXXXXXXXXXXXXXXX" type="text"  name="accountnumber"id="account_number" pattern="^[0][0][0-9]{8}$" required>

      <div class="cardForm-Field50">
        <label for="expiry">Valid To</label><rb>
        <input placeholder="MM/YY" type="text" name="expiry" class="secondRow" id="expiry_date" required>
      </div>
      <div class="cardForm-Field50">
        <label for="cvc">CVV(3 Digits)</label><br>
        <input placeholder="XXX" type="text" name="cvc" maxlength="3" class="secondRow incorrectInfo" id="cvv" pattern="[0-9]{3}" required>
      </div>
        
        <label for="name"> Pin(4 Digits)</label>
      <input placeholder="XXX XXX" type="text" name="zipcode" maxlength="4" id="zip_code" pattern="[0-9]{4}" required><br>
<button type="submit" class="btn btn-warning col-md-12" formaction="PaymentController">SUBMIT & PAY</button>
     

     
      
      <!-- Button Pay -->
<div class="pay_btn">
     <!-- <input type="submit" value=" Submit & Pay " class="button CardGood" id="submitt"></div>-->
      
      

      
    </form>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://jquerycreditcardvalidator.com/jquery.creditCardValidator.js'></script>

  

    <script  src="js1/index.js"></script>




</body>


</div>
</div>
</div>
</body>