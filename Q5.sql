Assignment 5:

5.1 Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.

drop view if exists order_view;
create view order_view as select o.order_id, o.order_amount, u.user_name, u.email_id, o.order_date, o.order_status, o.product_id from storefrontdb.order as o inner join user as u on o.user_id = u.user_id order by o.order_date >= DATE_SUB('2019-08-08', INTERVAL 2 MONTH) desc;

select * from order_view ;

5.2 Use the above view to display the Products(Items) which are in ‘shipped’ state.

select product_title, order_id from order_view inner join product using (product_id) where order_status='shipped';

5.3 Use the above view to display the top 5 most selling products.

select count(product_id), product_title from order_view inner join product using (product_id) order by product_id desc limit 5;
