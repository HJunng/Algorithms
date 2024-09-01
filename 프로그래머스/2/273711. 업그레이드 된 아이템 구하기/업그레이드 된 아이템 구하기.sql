-- 코드를 작성해주세요
SELECT ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO
WHERE ITEM_ID IN (SELECT T.ITEM_ID
                    FROM ITEM_INFO I
                    JOIN ITEM_TREE T
                      ON I.ITEM_ID = T.PARENT_ITEM_ID
                    WHERE RARITY = 'RARE')
ORDER BY 1 DESC;