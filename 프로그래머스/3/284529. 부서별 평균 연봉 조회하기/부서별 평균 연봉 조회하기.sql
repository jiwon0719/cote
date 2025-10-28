-- 부서별로 부서id, 영문부서명, 평균 연봉
-- 평균 연봉 : 첫째자리 반올림
-- 평균 연봉 기준 내림차순

SELECT
    E.DEPT_ID,
    DEPT_NAME_EN,
    ROUND(AVG(SAL), 0) AS 'AVG_SAL'
FROM 
    HR_EMPLOYEES E
LEFT JOIN
    HR_DEPARTMENT D ON E.DEPT_ID = D.DEPT_ID
GROUP BY
    E.DEPT_ID, DEPT_NAME_EN
ORDER BY
    3 DESC;