-- 코드를 입력하세요
SELECT LEFT(PRODUCT_CODE,2), COUNT(*)
FROM PRODUCT
GROUP BY 1