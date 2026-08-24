# Write your MySQL query statement below
with cte as(
    select * ,dense_rank() over(partition by departmentId order by salary desc)
    as rnk
    from Employee
)

select d.name as Department,e.name as Employee,e.salary as Salary
from cte e
join Department d
on e.departmentId=d.id
where rnk<=3
order by Salary desc