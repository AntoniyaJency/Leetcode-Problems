# Write your MySQL query statement below
select t.request_at as 'Day',
    round(sum(
        case 
            when t.status!='completed' then 1
            else 0
        end
    ) /COUNT(*),2) as 'Cancellation Rate'
from Trips t
join Users u
    on u.users_id=t.client_id
join Users d
    on d.users_id=t.driver_id
where u.banned='No' and d.banned='No'
and t.request_at between "2013-10-01" and "2013-10-03"
group by t.request_at 
