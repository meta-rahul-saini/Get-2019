Assignment 3:

Write SQL scripts for the following:

3.1 Display Shopper’s information along with number of orders he/she placed during last 30 days.

select 
    user.user_name,
    user.email_id,
    user.phone_number,
    count(o.user_id) as no_of_order_placed
from
    storefrontdb.order as o
        inner join
    user ON o.user_id = user.user_id
where o.order_date < DATE_SUB(now(), interval 30 day ) group by o.user_id;


3.2 Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.

select 
    user.user_name,
    sum(o.order_amount) as total_amount,
    count(user.user_id) as no_of_orders
from
    storefrontdb.order o
        inner join
    user ON o.user_id = user.user_id
group by o.user_id
order by total_amount desc
limit 10;

3.3 Display top 20 Products which are ordered most in last 60 days along with numbers.


select 
    product_title, count(p.product_id) as count
from
    storefrontdb.order as o
        inner join
    products_in_order as p ON o.order_id = p.order_id inner join product on p.product_id = product.product_id
where
    o.order_date >= DATE_SUB(now(), INTERVAL 60 DAY)
group by p.product_id order by count desc limit 20; 


3.4 Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale

select 
    month(o.order_date) as month, sum(o.order_amount) as revenue
from
    storefrontdb.order as o
where
    o.order_date >= DATE_SUB(now(), INTERVAL 6 MONTH)
group by month(o.order_date);


3.5 Mark the products as Inactive which are not ordered in last 90 days.
############################################
# products not bought in last 3 months = total # products - products boughts in last 3 month;
############################################

SET SQL_SAFE_UPDATES = 0;

update product set status = 0 where product_id not in (
select 
    product_id 
from
    storefrontdb.order as o
        inner join
    products_in_order as p ON o.order_id = p.order_Id
where
    order_date >= DATE_SUB(now(), INTERVAL 6 MONTH));

SET SQL_SAFE_UPDATES = 1;


3.6 Given a category search keyword, display all the Products present in this category/categories


select 
    product_id
from
    category
        inner join
    product_category ON category.category_id = product_category.category_id
where
    category_name = 'shoes';
         
3.7 Display top 10 Items which were cancelled most.

select 
    *, count(product_id) as count
from
    storefrontdb.order as o
        inner join
    products_in_order as p ON o.order_id = p.order_id
where
    order_status = 'cancelled'
group by product_id
order by count desc
limit 10;
