# Write your MySQL query statement below
with t1 as(
    select user_id,round(avg(activity_duration),2) as trial_avg_duration
    from UserActivity
    where activity_type ='free_trial'
    group by user_id
),
t2 as(
    select user_id,round(avg(activity_duration),2) as paid_avg_duration
    from UserActivity
    where activity_type ='paid'
    group by user_id
)

select a.user_id,a.trial_avg_duration,b.paid_avg_duration
from t1 a
join t2 b
on a.user_id=b.user_id