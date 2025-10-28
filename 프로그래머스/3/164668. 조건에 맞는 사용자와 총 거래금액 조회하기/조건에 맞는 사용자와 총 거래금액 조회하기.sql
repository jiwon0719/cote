-- 완료된 중고 거래의 총금액이 70만원 이상인 사람의 정보(회원id, 닉네임, 총거래금액)
-- 오름차순 : 총거래금액

-- 일단, 완료된 중고 거래의 총금액이 70만원 이상인 사람을 찾아

SELECT 
    USER_ID,
    NICKNAME,
    PRICE AS 'TOTAL_SALES'
FROM 
    (SELECT
        WRITER_ID, SUM(PRICE) AS 'PRICE'
    FROM
        USED_GOODS_BOARD
    WHERE
        STATUS LIKE 'DONE'
    GROUP BY
        WRITER_ID
    HAVING
        SUM(PRICE) >= 700000) AS B
LEFT JOIN 
    USED_GOODS_USER U ON B.WRITER_ID = U.USER_ID
ORDER BY
    3 ASC;