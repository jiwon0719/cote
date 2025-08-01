-- 코드를 입력하세요
SELECT
    CAR_TYPE, 
    COUNT(*) AS CARS
FROM 
    CAR_RENTAL_COMPANY_CAR
WHERE
    FIND_IN_SET('통풍시트', OPTIONS) OR 
    FIND_IN_SET('열선시트', OPTIONS) OR 
    FIND_IN_SET('가죽시트', OPTIONS)
GROUP BY
    CAR_TYPE
ORDER BY
    CAR_TYPE ASC;