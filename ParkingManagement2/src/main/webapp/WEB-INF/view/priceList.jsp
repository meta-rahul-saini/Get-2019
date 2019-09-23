<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Price List</title>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>

.error {
	font: 11pt verdana;
	font-weight: 70;
	color: red;
}
</style>

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="#">Home</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarText" aria-controls="navbarText"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarText">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">About
			</a></li>
			<li class="nav-item"><a class="nav-link" href="login">Log out</a>
			</li>
		</ul>
	</div>
	</nav>

	<br>
	<br>
	<div class="container">

		<form action="GeneratePass" method='post'>

			<select id="currencyName" name="currencyName" onchange="rateCard()">

				<option id="INR" value="INR">Indian Rupees</option>

				<option id="USD" value="USD">US Dollars</option>

				<option id="YEN" value="YEN">Japanese Yen</option>
			</select><br> <br>
			
			<div id="rateTable" style="display: block">
			
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th scope="col">S. No.</th>
							<th scope="col">type</th>
							<th scope="col">price</th>
							<th scope="col">select</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>daily</td>
							<td id="daily">${priceMap['daily']}</td>
							<td><div class="form-check">
									<input class="form-check-input" type="radio" id='plan'
										name='plan' value='daily' onclick="setAmount('daily')"> <label
										class="form-check-label" for="plan"> daily </label>
								</div></td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td>monthly</td>
							<td id="monthly">${priceMap['monthly']}</td>
							<td><div class="form-check">
									<input class="form-check-input" type="radio" id='plan'
										name='plan' value='monthly' onclick="setAmount('monthly')"><label
										class="form-check-label" for="plan">monthly</label>
								</div></td>
						</tr>
						<tr>
							<th scope="row">3</th>
							<td>yearly</td>
							<td id="yearly">${priceMap['yearly']}</td>
							<td><div class="form-check">
									<input class="form-check-input" type="radio" id='plan'
										name='plan' value='yearly' onclick="setAmount('yearly')"> <label
										class="form-check-label" for="plan"> yearly </label>
								</div></td>
						</tr>
					</tbody>
				</table>
				<input type="text" id="amount" name="amount" hidden></input>
				<input type='submit' value='get pass' />
		</form>
	</div>
</body>



<script>
 // used to show the rate cards in different currency
 
 // used to show the rate cards in different currency
 var vehicleId="${vehicleId}", currency='USD', amount, planName, symbol="USD", empId="${empId}";
 
  function rateCard()
  {
	  console.log(">>>>>>>>: ", "${vehicleId}");
      var type1 = "${vehicleType}", 
        exchangeFromRupee = 1; 
      currency = document.getElementById("currencyName").value;
      
      console.log(currency);
      
      if(currency == "USD"){
        exchangeFromRupee = 72.02;
        symbol = "USD";
      }
      else if(currency == "YEN"){
        exchangeFromRupee = 106.24;
        symbol = "JPY";
   }
  
//      document.getElementById("vehicleTypeName").innerHTML = document.getElementById(type).innerHTML;
//      document.getElementById("NameOfCurrency").innerHTML = document.getElementById(currency).innerHTML;
    const formatter = new Intl.NumberFormat('en-US', 
    	{
    	  style: 'currency',
    	  currency: symbol
    	})

	document.getElementById("daily").innerHTML = formatter.format(exchangeFromRupee * "${priceMap['daily']}");
    document.getElementById("monthly").innerHTML = formatter.format(exchangeFromRupee * "${priceMap['monthly']}");
    document.getElementById("yearly").innerHTML = formatter.format(exchangeFromRupee * "${priceMap['yearly']}");

    document.getElementById("rateTable").style.display = "block";
  } 
  
 
  function setAmount(plan){
	  
	  console.log("plan: ", plan);
	  if(plan=="daily"){
		  
		  document.getElementById("amount").value = "${priceMap['daily']}"; 
		  
		 console.log("${priceMap['daily']}");
	  }
	  else if(plan=="monthly"){
		  document.getElementById("amount").value = "${priceMap['monthly']}";
	  }
	  else if(plan == "yearly"){
		  document.getElementById("amount").value = "${priceMap['yearly']}";
	  }
  }

  </script>
</html>