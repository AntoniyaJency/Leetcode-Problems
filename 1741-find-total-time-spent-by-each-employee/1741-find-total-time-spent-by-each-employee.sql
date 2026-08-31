# Write your MySQL query statement below

with cte as(
select emp_id,event_day,sum(out_time-in_time) as total_time
from Employees
group by emp_id,event_day)

select event_day as day,emp_id,total_time
from cte