-- 사원별 성과금 정보 조회
-- 점수 : 상반기, 하반기 평균
-- HR_GRADE, HR_EMPLOYEES 조인 > 사번과 연도로 그룹화하고 스코어 합산해서 계산하기
-- 케이스 문으로 등급 표시

SELECT 
    E.EMP_NO, 
    E.EMP_NAME,
    (CASE 
        WHEN AVG(SCORE) >= 96 THEN 'S'
        WHEN AVG(SCORE) >= 90 THEN 'A'
        WHEN AVG(SCORE) >= 80 THEN 'B'
        ELSE 'C'
    END)AS GRADE, 
    (CASE 
        WHEN AVG(SCORE) >= 96 THEN E.SAL * 0.2
        WHEN AVG(SCORE) >= 90 THEN E.SAL * 0.15
        WHEN AVG(SCORE) >= 80 THEN E.SAL * 0.1
        ELSE 0
    END)AS BONUS
FROM 
    HR_EMPLOYEES E
JOIN
    HR_GRADE G ON E.EMP_NO = G.EMP_NO
WHERE
    YEAR = '2022'
GROUP BY
    E.EMP_NO, E.EMP_NAME, E.SAL
ORDER BY
    1 ASC;
