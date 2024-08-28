-- 코드를 작성해주세요
SELECT QUARTER, COUNT(*) ECOLI_COUNT
FROM (SELECT
        CASE
            WHEN MONTH(DIFFERENTIATION_DATE) BETWEEN 1 AND 3 THEN '1Q'
            WHEN MONTH(DIFFERENTIATION_DATE) BETWEEN 4 AND 6 THEN '2Q'
            WHEN MONTH(DIFFERENTIATION_DATE) BETWEEN 7 AND 9 THEN '3Q'
            ELSE '4Q'
        END AS QUARTER
    FROM ECOLI_DATA) Q
GROUP BY QUARTER
ORDER BY 1;



