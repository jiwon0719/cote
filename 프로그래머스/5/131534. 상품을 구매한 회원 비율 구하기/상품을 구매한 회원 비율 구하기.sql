-- 2021년에 가입한 전체 회원들만 데이터 추출(서브쿼리) from 
-- online_sale테이블 조인
-- 상품을 구매한 회원수 , 상품을 구매한 회원의 비율 구하기 : 년도와 달별로 그룹화하기 > count(*), 비율?
SELECT 
    YEAR(S.SALES_DATE) AS YEAR, 
    MONTH(S.SALES_DATE) AS MONTH, 
    COUNT(DISTINCT(S.USER_ID)) AS PURCHASED_USERS,
    ROUND((COUNT(DISTINCT(S.USER_ID)) / (SELECT COUNT(*) FROM USER_INFO WHERE YEAR(JOINED) = '2021')), 1) AS PURCHASED_RATIO
FROM (
    SELECT *
    FROM USER_INFO
    WHERE YEAR(JOINED) = '2021'
    ) AS I
JOIN 
    ONLINE_SALE S ON I.USER_ID = S.USER_ID
GROUP BY 
    YEAR, MONTH
ORDER BY
    1 ASC, 2 ASC;
