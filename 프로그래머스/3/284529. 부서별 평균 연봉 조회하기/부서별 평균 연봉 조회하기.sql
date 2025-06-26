-- 코드를 작성해주세요
-- 부서별 평균 연봉 조회
-- 평균 연봉은 소수점 첫째 자리에서 반올림
-- 부서별 평균 연봉으로 내림차순

-- 부서별로 그룹화
-- 연봉 평균구하기
-- 조인해서 부서 정보 얻기
SELECT
    E.DEPT_ID, 
    D.DEPT_NAME_EN, 
    ROUND(AVG(SAL), 0) AS AVG_SAL
FROM 
    HR_EMPLOYEES E
JOIN
    HR_DEPARTMENT D ON E.DEPT_ID = D.DEPT_ID
GROUP BY
    E.DEPT_ID
ORDER BY
    3 DESC;
