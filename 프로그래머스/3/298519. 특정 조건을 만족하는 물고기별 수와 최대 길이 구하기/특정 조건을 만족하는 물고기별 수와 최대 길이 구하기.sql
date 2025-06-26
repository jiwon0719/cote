-- 코드를 작성해주세요
-- 평균 길이 33 이상인 물고기 종류별로 분류 : 종류로 그룹화 > 평균 33 이상인것만 데이터 조회
-- 주의 : null 값은 10으로 먼저 데이터 가공 필요
SELECT 
    COUNT(*) AS FISH_COUNT, 
    MAX(LENGTH) AS MAX_LENGTH, 
    FISH_TYPE
FROM (
    SELECT 
        ID, 
        FISH_TYPE,
        IFNULL(LENGTH, 10) AS LENGTH
    FROM FISH_INFO
) FISH_INFO
GROUP BY
    FISH_TYPE
HAVING
    AVG(LENGTH) >= 33
ORDER BY
    3 ASC;
