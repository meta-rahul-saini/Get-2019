Assignment 2:
Write SQL scripts for the following:

2.1 Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.

select 
    product_id, product_title, count(*)
from
    product
group by product_title;



2.2 Display Count of products as per below price range:

SELECT 
    count(*)
FROM
    product
WHERE
    unit_price BETWEEN 0 and 100;
    
SELECT 
    count(*)
FROM
    product
WHERE
    unit_price BETWEEN 101 and 500;

SELECT 
    count(*)
FROM
    product
WHERE
    unit_price > 500;
	
  
  
2.3 Display the Categories along with number of products under each category.

select 
    category_name, count(product.category_id) as no_of_product
from
    product
        inner join
    category ON product.category_id = category.category_id
group by product.category_id;
