-- 코드를 입력하세요
SELECT
    ORDER_ID, 
    PRODUCT_ID, 
    DATE_FORMAT(IFNULL(OUT_DATE, ''), '%Y-%m-%d') AS OUT_DATE,
    (CASE 
        WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
        WHEN OUT_DATE > '2022-05-01' THEN '출고대기'
        ELSE '출고미정' 
     END) AS '출고여부'
FROM 
    FOOD_ORDER
ORDER BY
    1;
