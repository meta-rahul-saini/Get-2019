
# Create a function to calculate number of orders in a month. 
# Month and year will be input parameter to function.

DELIMITER //
DROP FUNCTION IF EXISTS no_of_orders //
CREATE FUNCTION `storefrontdb`.`no_of_orders`(month_value INT, year_value INT ) RETURNS int DETERMINISTIC
BEGIN
 DECLARE number INT;
  Select count(o.order_id) INTO number FROM storefrontdb.order AS o 
  WHERE MONTH(order_date) = month_value AND YEAR(order_date) = year_value;
  RETURN number;
END 

//

DELIMITER ;

SELECT no_of_orders(8, 2019);


# Create a function to return month in a year having maximum orders. Year will be input parameter.

DELIMITER //
DROP FUNCTION IF EXISTS month_of_max_orders //
CREATE FUNCTION `storefrontdb`.`month_of_max_orders`( year_value INT ) RETURNS int 
BEGIN 
 DECLARE number, maximum INT;
 
  CREATE TEMPORARY TABLE IF NOT EXISTS order_number as Select count(o.order_id) AS numberOfOrders, MONTH(o.order_date) AS monthNumber  FROM storefrontdb.order AS o
  WHERE YEAR(o.order_date) = year_value GROUP BY MONTH(o.order_date);
  set maximum = (select max(numberOfOrders) FROM order_number);
 ( SELECT  monthNumber INTO number FROM order_number  WHERE numberOfOrders = maximum);
  RETURN number;
END 

//

DELIMITER ;

SELECT month_of_max_orders(2019);



