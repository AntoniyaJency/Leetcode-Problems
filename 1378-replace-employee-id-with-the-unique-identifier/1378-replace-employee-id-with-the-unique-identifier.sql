# Write your MySQL query statement below
select uid.unique_id,eid.name
from Employees eid 
left join EmployeeUNI uid
on uid.id=eid.id
;