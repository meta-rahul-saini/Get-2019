
# Create a Stored procedure to retrieve average sales of each product in a month. 
# Month and year will be input parameter to function.


DELIMITER //
DROP PROCEDURE IF EXISTS avg_sale //
CREATE PROCEDURE `storefrontdb`.`avg_sale`(month_value INT, year_value INT )
BEGIN 
 DROP table IF EXISTS avg_sale; 
 create table avg_sale as 

  select i.product_id, sum(i.quantity) from storefrontdb.order as o  inner join item_order as i 
 on o.order_id = i.order_id  where month(o.order_date) = month_value and year(o.order_date)  = year_value group by i.product_id ; 

END 

//
DELIMITER ;
call avg_sale(7, 2019);

select * from avg_sale;

# Create a stored procedure to retrieve table having order detail with status for a given period. 
# Start date and end date will be input parameter. Put validation on input dates like start date is less than end date. 
# If start date is greater than end date take first date of month as start date.

DELIMITER //
DROP PROCEDURE IF EXISTS order_detail //
CREATE PROCEDURE `storefrontdb`.`order_detail`(start_date Date, end_date Date )
BEGIN 
 
 if (start_date >  end_date) then
 set start_date = Date_sub(end_date, interval day(end_Date) day);
 end if;
 DROP table IF EXISTS order_detail; 
 create table order_detail as 
 select * from storefrontdb.order where order_date between start_date and end_date; 
END 

//

DELIMITER ;


call order_detail('2019-09-01', '2019-08-30');

select 
    *
from
    order_detail;
