with cte as(
    select user_id,count(rating) as cnt
    from MovieRating
    group by user_id),

    ha as(
        select movie_id,avg(rating) as average
        from MovieRating
        where year(created_at)='2020' and month(created_at)=2
        group by movie_id
        
    )


(select u.name as results
from Users u
join cte c
on c.user_id=u.user_id
order by c.cnt desc,u.name asc 
limit 1)

union all

(select mo.title as results
from Movies mo
join ha h
on mo.movie_id=h.movie_id
order by h.average desc,mo.title asc
limit 1)