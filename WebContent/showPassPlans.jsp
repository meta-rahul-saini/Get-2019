<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, Dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 <script src="main.js"></script>
 
</head>
<body>

  <!--  delaration of variables -->
				<%!
				String daily, monthly, yearly = null;
				int vehicleId, empId = -1;
				%>                


                <% 
                // gettig data from session
                
                HttpSession httpSession = request.getSession();
                empId = (int)httpSession.getAttribute("empId");
                 
                String vehicleType =  (String)httpSession.getAttribute("vehicleType");
                
                System.out.println("empId:  " + empId + "vehicleType: " + vehicleType );
                
                Connection connection = null;
                
				try 
                {        		
                connection = ConnectionFactory.getConnection();
                
                Statement stmt = connection.createStatement();

                String fetchPlanQuery = "select * from priceList where vehicleType = '"+vehicleType+ "';";
                
                ResultSet rs = stmt.executeQuery(fetchPlanQuery);
                
                if(rs.next()) 
                {      
                	// fetching vehicle Id and plans for daily, monthly, and yearly
                	
                	   vehicleId = rs.getInt(1); 
                	   
                	   session.setAttribute("vehicleId", vehicleId);
                			
                       daily = rs.getString(3); 
                       
                       monthly = rs.getString(4); 
                       
                       yearly = rs.getString(5); 
                       
                       System.out.println("daily: " + daily + " monthly: " + monthly);
                }
                else
                {
                	RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
    			    session.setAttribute("errorMessage", "Vehicle not registered!");
    				rd.forward(request,response);  
                }
                
             
               
                }
            	catch (SQLException e) {
            			e.printStackTrace();
            	}
                
                %>

     <div id="rateInfo" style="display:block" align="center">
     
       <form action='GeneratePass' method='post'>      
       
            <select id="currencyName" name="currencyName" onchange="rateCard()">
                    
                    <option id="INR" value="INR">Indian Rupees</option>
                    
                    <option id="USD" value="USD">US Dollars</option>
                    
                    <option id="YEN" value="YEN">Japanese Yen</option>
            </select><br><br>
       
       		 <div id = "rateTable" style="display:block">
            	<table border='5px'>
                <tr id="vehicleType"><%=vehicleType %> </tr>
                <tr>
                    <th> Duration</th>
                    <th id="NameOfCurrency"></th> 
                    
                </tr>
                <tr>
                    <th>Daily </th>
                    <th id="daily">$<%=daily%></th>  
                    <th><input id='plan' type="radio"  name='plan' value='daily' ></input></th>  
                </tr>
                <tr>
                    <th>Monthly</th> 
                    <th id="monthly">$<%=monthly%></th> 
                    <th><input type='radio' id='plan' name='plan' value='monthly' ></input></th>
                </tr>
                <tr>
                    <th>Yearly</th> 
                    <th id="yearly">$<%=yearly%></th> 
                    <th><input type='radio' id='plan' name='plan' value='yearly' ></input></th>
                </tr>
            </table></div>
			<input type='submit' value= 'get pass'/>
           </form>
     
</body>
<script>
 // used to show the rate cards in different currency
 
 // used to show the rate cards in different currency
 var vehicleId=<%=vehicleId%>, currency='USD', amount, planName, symbol="USD", empId=<%=empId%>;
 
  function rateCard()
  {
      var type1 = document.getElementById("vehicleType").value, 
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
    
    	      if("${vehicleType}" == "cycle"){
    	        document.getElementById("daily").innerHTML = formatter.format(exchangeFromRupee * 5) ;
    	        document.getElementById("monthly").innerHTML = formatter.format(exchangeFromRupee * 100);
    	        document.getElementById("yearly").innerHTML = formatter.format(exchangeFromRupee * 500);
    	      }
    	      else if("${vehicleType}" == "twoWheeler"){
    	        document.getElementById("daily").innerHTML = formatter.format(exchangeFromRupee * 10);
    	        document.getElementById("monthly").innerHTML = formatter.format(exchangeFromRupee * 200);
    	        document.getElementById("yearly").innerHTML = formatter.format(exchangeFromRupee * 1000);
    	      }
    	      else if("${vehicleType}" == "fourWheeler"){
    	        document.getElementById("daily").innerHTML = formatter.format(exchangeFromRupee * 20);
    	        document.getElementById("monthly").innerHTML = formatter.format(exchangeFromRupee * 500);
    	        document.getElementById("yearly").innerHTML = formatter.format(exchangeFromRupee * 3500);
    	      }
    	      document.getElementById("rateTable").style.display = "block";
  } 
  
 
  function setAmount(plan){
	  if(plan=="daily"){
		  <%! float amount = 0;%>
		  
		  amount = document.getElementById("daily").innerHTML;                 
		  
		  planName = "daily";
	  }
	  else if(plan=="monthly"){
		  amount = document.getElementById("monthly").innerHTML;
		  planName = "monthly";
	  }
	  else if(plan == "yearly"){
		  amount = document.getElementById("yearly").innerHTML;
		  planName = "yearly";
	  }
	  //amount = amount.substring(0, str.length - 1);
	  <% request.getSession().setAttribute("amount", amount);%>
  }
  
  function getPass(){
	  
	  window.location.assign("GeneratePass?amount="+amount);
  }
  </script>
</html>