-- 코드를 작성해주세요
# SELECT
#     ID,
#     CASE
#         WHEN PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC)>=0 AND PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC)<=0.25 THEN 'CRITICAL'
#         WHEN PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC)>=0.26 AND PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC)<=0.50 THEN 'HIGH'
#         WHEN PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC)>=0.51 AND PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC)<=0.75 THEN 'MEDIUM'
#         ELSE 'LOW'
#     END AS COLONY_NAME
# FROM ECOLI_DATA
# ORDER BY ID;

WITH TOTAL_COUNT AS (
    SELECT COUNT(*) AS TOTAL FROM ECOLI_DATA
),
ECOLI_RANK_DATA AS (
    SELECT ID, SIZE_OF_COLONY, ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS RANK_SIZE
    FROM ECOLI_DATA
)

SELECT 
    ID, 
    # RANK_SIZE/TOTAL*100,
    CASE
        WHEN RANK_SIZE/TOTAL*100>=0 AND RANK_SIZE/TOTAL*100<=25 THEN 'CRITICAL'
        WHEN RANK_SIZE/TOTAL*100>25 AND RANK_SIZE/TOTAL*100<=50 THEN 'HIGH'
        WHEN RANK_SIZE/TOTAL*100>50 AND RANK_SIZE/TOTAL*100<=75 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM TOTAL_COUNT, ECOLI_RANK_DATA
ORDER BY ID;