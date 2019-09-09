/**
 * 
 */
  
  // function to validate employee name 
  function validateName()
  {
    var nameFormat = /^[a-zA-Z ]*$/;
    var name = document.getElementById("fullName").value;
    const min = 2;
    console.log('dddddddd');
    if((name.match(nameFormat))){
      return true;
      
      console.log('name matched;');
    }
    else if ((name.length < min))
    {
        alert("Length of name should be minimum 2");
        document.getElementById("fullName").value = "";
        return false;
    }
    else{
      alert("not all charaters");
      document.getElementById("fullName").value = "";
      return false;
    }
  }


// function to validate email id
function validateEmail()
{
    var mailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var email = document.getElementById("email").value;
    var atPosition=email.indexOf("@");  
    var dotPosition=email.lastIndexOf(".");  
    
    if(email.match(mailFormat)){
      return true;
    
      console.log('email matched;');
    }
    else if (atPosition<1 || dotPosition<atPosition+2 || dotPosition+2>=email.length){  
        alert("Please enter a valid e-mail address");  
        document.getElementById("email").value = "";
        return false;  
    }
    else{
     alert("Please enter valid email address!");
      document.getElementById("email").value = "";
      return false;
    }
  }
  
  // function to validate password
//  function validatePassword()
//  {
//    var pass = document.getElementById("password").value
//    var passFormat = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$/;
//
//    if(pass.match(passFormat))
//    {
//        return true;
//    }
//    else{
//        alert("Password -> should contains Uppercase, Lowercase, Numeric, Alphanumeric, and length minimum 8");
//        document.getElementById("password").value = "";
//        return false;
//    }
// }
 
 // function to check weather the password and confirm password are equal or not
 function isPassEqual()
 {
    const pass = document.getElementById("password").value;
    const confirmPass = document.getElementById("confirmPassword").value;
    if(pass != confirmPass)
    {
      alert("password not matched");
      document.getElementById("confirmPassword").value = "";
      return false;
    }
    else{
        console.log('passmatched;');
      return true;
    }
  }

//   function to validate contact details
  function validateContact()
  {
      var contact = document.getElementById("contact").value;
      if(isNaN(contact) || contact.length < 9) {
        alert("Not a valid number");
        document.getElementById("contact").value = "";
        return false;
    }
    else {
        return true;
    }

  }
  
  // function to hid the employee details
  function hideEmpDetail()
  {
    if( validateEmail() && validateName() && validatePassword() && isPassEqual() )
    {
        document.getElementById("empDetail").style.display = "none";
    document.getElementById("empDetail").innerHTML = "You have successfully registered! your reg. ID is : 1217"; 
    document.getElementById("vehicleForm").style.display = "block";
    }  
}
  
  
  // used to show the rate cards in different currency
  function rateCard()
  {
      var type = document.getElementById("vehicleType").value,
        currency = document.getElementById("currencyName").value, 
        exchangeFromRupee = 1;
      console.log("fffff: ",currency);
      if(currency == "USD"){
        exchangeFromRupee = 0.014;
      }
      else if(currency == "YEN"){
        exchangeFromRupee = 1.47;
      }
  
//      document.getElementById("vehicleTypeName").innerHTML = document.getElementById(type).innerHTML;
//      document.getElementById("NameOfCurrency").innerHTML = document.getElementById(currency).innerHTML;
  
      if(type == "cycle"){
        document.getElementById("dailyPrice").innerHTML = exchangeFromRupee * 5;
        document.getElementById("monthlyPrice").innerHTML = exchangeFromRupee * 100;
        document.getElementById("yearlyPrice").innerHTML = exchangeFromRupee * 500;
      }
      else if(type == "twoWheeler"){
        document.getElementById("dailyPrice").innerHTML = exchangeFromRupee * 10;
        document.getElementById("monthlyPrice").innerHTML = exchangeFromRupee * 200;
        document.getElementById("yearlyPrice").innerHTML = exchangeFromRupee * 1000;
      }
      else if(type == "fourWheeler"){
        document.getElementById("dailyPrice").innerHTML = exchangeFromRupee * 20;
        document.getElementById("monthlyPrice").innerHTML = exchangeFromRupee * 500;
        document.getElementById("yearlyPrice").innerHTML = exchangeFromRupee * 3500;
      }
      document.getElementById("rateTable").style.display = "block";
  } 
  
  

//  // display the price
//  function displayRate()
//  {
//	  
//    var varvehicleType = document.getElementById("vehicleType").value,
//      vehicleNumber = document.getElementById("vehicleNumber").value,
//      employeeId = document.getElementById("employeeId").value;
//  
//    if(vehicleName != "" && vehicleType != "select type" && vehicleNumber != "" && employeeId != ""){
//      document.getElementById("vehicleForm").style.display = "none";
//      document.getElementById("rateInfo").style.display = "block";
//    }
//  }

  // generate a price message for selected of selected plan
  function priceList(duration)
  {
    var price = document.getElementById(duration).innerHTML;
    document.getElementById("passID").innerHTML = "Pass price of your selected plan is" + price;
   }
   
   // function to generate pass for selected plan
   function generatePass()
   {
     document.getElementById("passID").style.display = "block";
   }