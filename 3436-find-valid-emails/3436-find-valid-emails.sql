# Write your MySQL query statement below
select user_id,email
from Users
where email regexp '^[A-Za-z0-9_]+[@][a-zA-Z]+[.]com$'
order by user_id