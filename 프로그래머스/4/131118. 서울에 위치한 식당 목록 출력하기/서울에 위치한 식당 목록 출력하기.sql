-- 코드를 입력하세요
SELECT RI.REST_ID, RI.REST_NAME, RI.FOOD_TYPE, RI.FAVORITES, RI.ADDRESS, RS.SCORE
FROM REST_INFO AS RI
JOIN (
    SELECT REST_ID, ROUND(AVG(REVIEW_SCORE),2) AS SCORE
    FROM REST_REVIEW
    GROUP BY REST_ID
) AS RS ON RI.REST_ID = RS.REST_ID
WHERE RI.ADDRESS LIKE '서울%'
ORDER BY 6 DESC, 4 DESC;