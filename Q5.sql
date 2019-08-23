Assignment 5:

5.1 Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.

drop view if exists order_view;

create view order_info as select o.order_id, product_title, unit_price, user_name, email_id, order_date, order_status from storefrontdb.order as o inner join products_in_order as p on o.order_id = p.order_id inner join product on p.product_id = product.product_id inner join user on o.user_id = user.user_id order by order_date desc;

5.2 Use the above view to display the Products(Items) which are in ‘shipped’ state.

select 
    *
from
    order_info
where
    order_status = 'shipped';

5.3 Use the above view to display the top 5 most selling products.


select 
    product_title, count(product_title) as count
from
    order_info
group by product_title
order by count desc
limit 5;
