-- 코드를 입력하세요
SELECT
    FLOOR(PRICE/10000)*10000 AS PRICE_GROUP,
    COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY 1
ORDER BY 1