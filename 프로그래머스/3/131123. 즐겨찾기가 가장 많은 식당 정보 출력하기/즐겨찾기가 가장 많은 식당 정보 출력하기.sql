-- food_type을 기준으로 가장 큰 즐겨찾기 수를 가진 튜플 뽑아내기
# select FOOD_TYPE, REST_NAME, max(FAVORITES)
# from REST_INFO
# group by food_type

select a.FOOD_TYPE, a.REST_ID, a.REST_NAME, a.FAVORITES
from REST_INFO as a inner join (
    select FOOD_TYPE, max(FAVORITES) as maxFav
    from REST_INFO
    group by FOOD_TYPE
) as b
on a.FOOD_TYPE = b.FOOD_TYPE and a.FAVORITES = b.maxFav
order by a.FOOD_TYPE desc