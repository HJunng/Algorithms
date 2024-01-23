# select a.FOOD_TYPE, a.REST_ID, a.REST_NAME, a.FAVORITES
# from REST_INFO as a join (
#     select FOOD_TYPE, max(FAVORITES) as maxFav
#     from REST_INFO
#     group by FOOD_TYPE
# ) as b
# on a.FOOD_TYPE = b.FOOD_TYPE and a.FAVORITES = b.maxFav
# order by a.FOOD_TYPE desc

SELECT
  FOOD_TYPE,
  REST_ID AS ID,
  REST_NAME AS 식당이름,
  FAVORITES AS 즐겨찾기수
FROM
  REST_INFO r1
WHERE
  FAVORITES = (
    SELECT
      MAX(FAVORITES)
    FROM
      REST_INFO r2
    WHERE
      r1.FOOD_TYPE = r2.FOOD_TYPE
  )
ORDER BY
  FOOD_TYPE DESC;