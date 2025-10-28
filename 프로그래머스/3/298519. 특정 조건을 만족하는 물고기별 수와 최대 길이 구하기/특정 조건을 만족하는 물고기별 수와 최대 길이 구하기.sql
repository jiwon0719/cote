-- 평균 길이가 33 이상인 물고기들을 종류별로 분류 
-- 잡은 수, 최대 길이, 물고기 종류 출력
-- 물고기 종류 오름차순
-- 10 이하는 10으로 취급

SELECT
    COUNT(*) AS 'FISH_COUNT',
    MAX(IFNULL(LENGTH, 10)) AS 'MAX_LENGTH',
    FISH_TYPE
FROM 
    FISH_INFO
GROUP BY
    FISH_TYPE
HAVING
    AVG(IFNULL(LENGTH, 10)) >= 33
ORDER BY
    3 ASC;