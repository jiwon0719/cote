-- 코드를 작성해주세요
-- 1. 타입별로 가장 긴 물고기 구하기
-- 2. 그 물고기의 정보 받아오기
SELECT
    I.ID,
    N.FISH_NAME, 
    I.LENGTH
FROM 
    FISH_INFO I
JOIN
    FISH_NAME_INFO N ON I.FISH_TYPE = N.FISH_TYPE
WHERE
    (I.FISH_TYPE, I.LENGTH) IN (
        SELECT FISH_TYPE, MAX(LENGTH)
        FROM FISH_INFO
        GROUP BY FISH_TYPE
    )