Assignment 3:

Write SQL scripts for the following:

3.1 Display Shopper’s information along with number of orders he/she placed during last 30 days.

select 
    user.user_id,
    user.user_name,
    user.phone_number,
    user.email_id,
    count(user.user_id) as no_of_orders_placed_in_last_30_days
from
    user
        inner join
    storefrontdb.order ON user.user_id = storefrontdb.order.user_id
where
    order_date >= DATE_SUB('2008-12-12', INTERVAL 30 DAY)
group by user_id;


3.2 Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.

drop view if exists max_revenue;

create view max_revenue as select user.user_name as user_name, sum(o.order_amount) as total_amount, count(user.user_id) 
as no_of_orders from `storefrontdb`.`order` o inner join user on o.user_id = user.user_id group by user.user_id;

select 
    *
from
    max_revenue
order by total_amount desc
limit 10;

3.3 Display top 20 Products which are ordered most in last 60 days along with numbers.

select 
    product.product_title, count(o.product_id) as freq
from
    storefrontdb.order as o
        inner join
    product ON product.product_id = o.product_id
where
    o.order_date >= DATE_SUB('2019-12-12', INTERVAL 60 DAY)
group by product.product_title
order by freq desc
limit 10;

3.4 Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale

select * from storefrontdb.order;

select month(o.order_date) as month, sum(o.order_amount) from storefrontdb.order as o where o.order_date >= DATE_SUB('2008-12-12', INTERVAL 6 MONTH) group by month(o.order_date);

3.5 Mark the products as Inactive which are not ordered in last 90 days.
############################################
# products not bought in last 3 months = total # products - products boughts in last 3 month;
############################################

# products which are not bought in last 3 month

drop table if exists product_id_not_bought_in_last_30_month;

create table product_id_not_bought_in_last_30_month as select product_id from
    product
where
    product_id not in (select 
        product_id
    from
        (
        # products which are bought in last 3 month
        select 
            product.product_id,
                status,
                added_time,
                product_description,
                product_title,
                quantity,
                unit_price,
                category_id
        from
            storefrontdb.order as o
        inner join product ON o.product_id = product.product_id
        where
            order_date >= DATE_SUB('2019-08-08', INTERVAL 3 MONTH)
            ) as T );

select * from product_id_not_bought_in_last_30_month;


SET SQL_SAFE_UPDATES = 0;

update product set status = 0 where product_id in ( select product_id from product_id_not_bought_in_last_30_month);

SET SQL_SAFE_UPDATES = 1;


3.6 Given a category search keyword, display all the Products present in this category/categories

select * from product inner join category on product.category_Id = category.category_id where category_name =  "shoes";


3. 7 Display top 10 Items which were cancelled most.

select * from storefrontdb.order where order_status = "cancelled" group by product_id order by count(*) desc limit 10 ;

