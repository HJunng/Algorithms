-- 코드를 작성해주세요
WITH INFO AS (
    SELECT ID, FISH_TYPE, IFNULL(LENGTH,10) AS LENGTH, TIME
    FROM FISH_INFO
)

SELECT COUNT(*) FISH_COUNT, MAX(LENGTH) MAX_LENGTH, FISH_TYPE
FROM INFO
GROUP BY FISH_TYPE
HAVING AVG(LENGTH) >= 33
ORDER BY FISH_TYPE;

