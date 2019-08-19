select 
    product_id, product_title, count(*)
from
    product
group by product_title having count(*) > 1;
