# -- 코드를 작성해주세요
SELECT
    ITEM_ID, 
    ITEM_NAME, 
    RARITY
FROM 
    ITEM_INFO
WHERE
    ITEM_ID NOT IN (
        SELECT PARENT_ITEM_ID
        FROM ITEM_TREE
        WHERE PARENT_ITEM_ID IS NOT NULL -- IN 집합에 null값이 포함되는 경우, 전체 결과가 빈 집합이 된다. 
    )
ORDER BY
    1 DESC;
