# Write your MySQL query statement below
with cte as(
    select *,row_number() over(order by id) as p
    from Stadium
    where people >=100
),
cnt as(
    select *,id-p as c
    from cte
),

new as(
    select *,count(*) over(partition by c) as n
    from cnt
)

select id,visit_date,people
from new
where n>=3
order by visit_date