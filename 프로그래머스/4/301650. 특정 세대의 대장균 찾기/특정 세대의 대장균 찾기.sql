-- 코드를 작성해주세요
WITH PARENT_DATA AS (
    SELECT ID, PARENT_ID
    FROM ECOLI_DATA
)

SELECT D1.ID
FROM PARENT_DATA D1
    JOIN PARENT_DATA D2 ON D1.PARENT_ID = D2.ID
    JOIN PARENT_DATA D3 ON D2.PARENT_ID = D3.ID
    LEFT JOIN PARENT_DATA D4 ON D3.PARENT_ID = D4.ID
WHERE D4.ID IS NULL
ORDER BY 1;