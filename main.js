var name;
function validateName() {
    name = document.getElementById("name").value;
    console.log("username: ", name);
    var filterName = new RegExp('\\d');
    if (name.length <= 2) {
        document.getElementById("name").style.border = "1px solid red";
    } else if (filterName.test(name)) {
        document.getElementById("name").style.border = "1px solid red";
    } else {

        // we are here means we have successfully entered name
        document.getElementById("employee-email").style.display = "block";
        document.getElementById("employee-name").style.display = "none";
        document.getElementById("employee-email-label").innerText = "Hello " + name + " Enter your Email ";
        return true;
    }
    return false
}

function validateEmail() {
    var filterEmail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var email = document.getElementById("email").value;
    if (!filterEmail.test(email)) {
        document.getElementById("email").style.border = "1px solid red";
    } else {
        document.getElementById("email").style.border = "1px solid green";
        document.getElementById("employee-contact-label").innerText = "Very Nice " + name + ".., Now share Your Contact Number";
        document.getElementById("employee-email").style.display = "none";
        document.getElementById("employee-contact").style.display = "block";
        return true;
    }
    return false
}

function validateContact() {

    var contact = document.getElementById("contact").value;;
    console.log("contact: ", contact);
    var filterContact = new RegExp('\\d');
    if (!(contact.length <= 10 && contact.length >= 8)) {
        document.getElementById("contact").style.border = "1px solid red";
    } else if (!filterContact.test(contact)) {
        document.getElementById("contact").style.border = "1px solid red";
    } else {
        document.getElementById("employee-password-label").innerText = "good...! For security purpose  choose good password which contain number,alphabate,small and upper case";
        document.getElementById("employee-contact").style.display = "none";
        document.getElementById("employee-password").style.display = "block";
        return true;
    }
    return false
}
var password ;
function validatePassword() {

    password = document.getElementById("password").value;
    var filterPassword = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    if (password.length <= 8) {
        document.getElementById("password").style.border = "1px solid red";
    } else if (!filterPassword.test(password)) {
        document.getElementById("password").style.border = "1px solid yellow";
    } else {
        document.getElementById("password").style.border = "1px solid green";
        document.getElementById("employee-confirm-password-label").innerText = "Awesome ....!now again enter it to confirm";
        document.getElementById("employee-password").style.display = "none";
        document.getElementById("employee-confirm-password").style.display = "block";

        return true;
    }
    return false
}

function validateConfirmPassword() {

    confirmPassword = document.getElementById("confirm-password").value;

    if(password != confirmPassword)
    {
        document.getElementById("employee-confirm-password-label").innerText = "Password not matched..."
        return false;
    }
    document.getElementById("employee-confirm-password").style.display = "none";
    document.getElementById("employee-gender").style.display = "block";
    return true;
}

function generateVehicleForm() {

    var content = document.getElementById("content").value;

    if (document.getElementById("female").checked || document.getElementById("male").checked) {
        content = document.getElementById("female").value
        document.getElementById("employee-gender").style.display = "none";
        document.getElementById("vehicle-name-form").style.display = "block";
        document.body.style.backgroundColor = "rgba(172, 255, 47, 0.356)";
        document.getElementById("vehicle-name").style.backgroundColor = "rgba(172, 255, 47, 0.226)";
        document.getElementById("vehicle-name-label").innerText = "Enter Vehicle Name";
    }
    else {
        document.getElementById("employee-gender-label").innerText = "Please Select Gender";
    }
}

function submitVehicleName() {
    var vehicleName = document.getElementById("vehicle-name").value;

    if (vehicleName.length > 2) {
        document.getElementById("vehicle-name-form").style.display = "none";
        document.getElementById("vehicle-type-form").style.display = "block";
        document.getElementById("vehicle-type-label").innerText = "Enter Vehicle Name";
    }
    else {
        document.getElementById("vehicle-name-label").innerText = "Please Enter valid vehicle Name";
    }
}

var vehicleType ;

function submitVehicleType() {
    vehicleType = document.getElementById("vehicle-type").value;

    document.getElementById("vehicle-type-form").style.display = "none";
    document.getElementById("vehicle-number-form").style.display = "block";
    document.getElementById("vehicle-type-label").innerText = "Enter Vehicle Number";
}

function submitVehicleNumber() {
    var vehicleName = document.getElementById("vehicle-number").value;
    document.getElementById("vehicle-number-form").style.display = "none";
    document.getElementById("vehicle-identification-form").style.display = "block";
    document.getElementById("vehicle-type-label").innerText = "Enter Vehicle identification details";
}

function submitVehicleIdentification() {
    var vehicleName = document.getElementById("vehicle-identification").value;
    document.getElementById("vehicle-identification-form").style.display = "none";
    document.getElementById("get-pass-form").style.display = "block";
    document.getElementById("vehicle-type-label").innerText = "select pass...";
}


var currency = 'USD', amount, planName, symbol = "USD";

function rateCard() {
    var type1 = vehicleType
    exchangeFromRupee = 1;
    currency = document.getElementById("currencyName").value;

    document.getElementById("select-currency-label").innerText = "Select your currency...";

    console.log(type1);
    console.log(currency);

    if(currency=="INR")
    {
        exchangeFromRupee = 1;
        symbol = "INR";
    }

    if (currency == "USD") {
        exchangeFromRupee = 1/72.02;
        symbol = "USD";
    }
    else if (currency == "YEN") {
        exchangeFromRupee = 1/106.24;
        symbol = "JPY";
    }

    //      document.getElementById("vehicleTypeName").innerHTML = document.getElementById(type).innerHTML;
    //      document.getElementById("NameOfCurrency").innerHTML = document.getElementById(currency).innerHTML;
    const formatter = new Intl.NumberFormat('en-US',
        {
            style: 'currency',
            currency: symbol
        })

    if (type1 == "cycle") {
        document.getElementById("daily").innerHTML = formatter.format(exchangeFromRupee * 5);
        document.getElementById("monthly").innerHTML = formatter.format(exchangeFromRupee * 100);
        document.getElementById("yearly").innerHTML = formatter.format(exchangeFromRupee * 500);
    }
    else if (type1 == "two-wheeler") {
        document.getElementById("daily").innerHTML = formatter.format(exchangeFromRupee * 10);
        document.getElementById("monthly").innerHTML = formatter.format(exchangeFromRupee * 200);
        document.getElementById("yearly").innerHTML = formatter.format(exchangeFromRupee * 1000);
    }
    else if (type1 == "four-wheeler") {
        document.getElementById("daily").innerHTML = formatter.format(exchangeFromRupee * 20);
        document.getElementById("monthly").innerHTML = formatter.format(exchangeFromRupee * 500);
        document.getElementById("yearly").innerHTML = formatter.format(exchangeFromRupee * 3500);
    }
    document.getElementById("rateTable").style.display = "block";
}


function setAmount(plan) {
    if (plan == "daily") {
        amount = document.getElementById("daily").innerHTML;
        planName = "daily";
    }
    else if (plan == "monthly") {
        amount = document.getElementById("monthly").innerHTML;
        planName = "monthly";
    }
    else if (plan == "yearly") {
        amount = document.getElementById("yearly").innerHTML;
        planName = "yearly";
    }
}


function getPass() {
    document.getElementById("get-pass-form").style.display = "none";
    document.getElementById("pass-form").style.display = "block";
    var amount = 0;
    if(document.getElementById("dailyRadio").checked)
    {
        amount = document.getElementById("daily").innerText;
    }
    if(document.getElementById("monthlyRadio").checked)
    {
        amount = document.getElementById("monthly").innerText;
    }
    if(document.getElementById("yearlyRadio").checked)
    {
        amount = document.getElementById("yearly").innerText;
    }
    
    document.getElementById("showPrice").innerHTML=" Give " + " <i>" + amount  + "</i>";
}


