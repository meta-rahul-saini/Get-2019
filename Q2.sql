Assignment 2:
Write SQL scripts for the following:

2.1 Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.

select 
    product_id
from
    product_category
group by product_id
having count(product_id) > 1;



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
    category_name, count(product_category.category_id)
from
    product_category
        inner join
    category ON product_category.category_id = category.category_id
group by product_category.category_id;
