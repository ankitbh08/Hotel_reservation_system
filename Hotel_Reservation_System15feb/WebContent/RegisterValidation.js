/**
 * 
 */
function Validate() {
        var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("confirm_password").value;
        var res=true;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            res=false;
        }
        if(!res){
        var element= document.getElementById('password');
        element.focus();
        element.onblur= function() {
            
        };
        }
        return res;
    }
function TDate() {
    var UserDate = document.getElementById("dob").value;
    var ToDate = new Date();
var res=true;
    if (new Date(UserDate).getTime() >= ToDate.getTime()) {
          alert("The Date must be Bigger or Equal to today date");
          res=false;
     }
    if(!res){
    	var element=document.getElementById('dob');
    	element.focus();
        element.onblur= function() {
            
        };
    }
    return res;
}
function Check_Out_Date() {
    var UserDate = document.getElementById("check_date").value;
    var ToDate = document.getElementById("check_out_date").value;
var res=true;
    if (new Date(UserDate).getTime() >= new Date(ToDate).getTime()) {
          alert("The Date must be Bigger or Equal to today date");
          res=false;
     }
    if(!res){
    	var element=document.getElementById('check_date');
    	element.focus();
        element.onblur= function() {
            
        };
    }
    return res;
}
function Check_In_Date() {
    var UserDate = document.getElementById("check_date").value;
    var ToDate = new Date();
var res=true;
    if (new Date(UserDate).getTime() <= ToDate.getTime()) {
          alert("The Date must be Bigger or Equal to today date");
          res=false;
     }
    if(!res){
    	var element=document.getElementById("check_date");
    	element.focus();
        element.onblur= function() {
            
        };
    }
    return res;
}
function checkPassword()
{
  // at least one number, one lowercase and one uppercase letter
  // at least six characters
	var str=document.getElementById("password").value;
  var re = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
  return re.test(str);
}

function phonenumber()
{
	var inputtxt = document.f1.getElementById("contact").value;
  var phoneno = /^(\+91-|\+91|0)?\d{10}$/;
  var res=false;
  if((inputtxt.value.match(phoneno)))
        {
      res=true;
        }
      else
        {
        alert("Invalid Phone Number");
        var element= document.getElementById('contact');
        element.focus();
        element.onblur= function() {
            
        };
        }
  return res;
}

function addEvent(node, type, callback) {
	  if (node.addEventListener) {
	    node.addEventListener(
	      type,
	      function(e) {
	        callback(e, e.target);
	      },
	      false
	    );
	  } else if (node.attachEvent) {
	    node.attachEvent("on" + type, function(e) {
	      callback(e, e.srcElement);
	    });
	  }
	}

	//identify whether a field should be validated
	//ie. true if the field is neither readonly nor disabled,
	//and has either "pattern", "required" or "aria-invalid"
	function shouldBeValidated(field) {
	  return (
	    !(field.getAttribute("readonly") || field.readonly) &&
	    !(field.getAttribute("disabled") || field.disabled) &&
	    (field.getAttribute("pattern") || field.getAttribute("required"))
	  );
	}

	//field testing and validation function
	function instantValidation(field) {
	  //if the field should be validated
	  if (shouldBeValidated(field)) {
	    //the field is invalid if:
	    //it's required but the value is empty
	    //it has a pattern but the (non-empty) value doesn't pass
	    var invalid =
	      (field.getAttribute("required") && !field.value) ||
	      (field.getAttribute("pattern") &&
	        field.value &&
	        !new RegExp(field.getAttribute("pattern")).test(field.value));

	    //add or remove the attribute is indicated by
	    //the invalid flag and the current attribute state
	    if (!invalid && field.getAttribute("aria-invalid")) {
	      field.removeAttribute("aria-invalid");
	    } else if (invalid && !field.getAttribute("aria-invalid")) {
	      field.setAttribute("aria-invalid", "true");
	    }
	  }
	}

	//now bind a delegated change event
	//== THIS FAILS IN INTERNET EXPLORER <= 8 ==//
	//addEvent(document, 'change', function(e, target)
	//{
	//  instantValidation(target);
	//});

	//now bind a change event to each applicable for field
	var fields = [
	  document.getElementsByTagName("input"),
	  document.getElementsByTagName("textarea")
	];
	for (var a = fields.length, i = 0; i < a; i++) {
	  for (var b = fields[i].length, j = 0; j < b; j++) {
	    addEvent(fields[i][j], "change", function(e, target) {
	      instantValidation(target);
	    });
	  }
	}