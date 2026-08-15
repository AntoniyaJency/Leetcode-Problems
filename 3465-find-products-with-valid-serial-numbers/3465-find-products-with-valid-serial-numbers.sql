# Write your MySQL query statement below
select product_id,product_name,description
from products
where description regexp '(^|[^0-9A-Za-z])(?-i:SN)[0-9]{4}-[0-9]{4}($|[^0-9A-Za-z])'
order by product_id