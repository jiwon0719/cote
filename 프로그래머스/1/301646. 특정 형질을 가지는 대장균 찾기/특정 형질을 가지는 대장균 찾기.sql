-- 2번 형질을 보유하지 않으면서
-- 1번이나 3번 형질을 보유하고 있는 대장균 개체의 수를 count(모두 보유한 것도 인정)

SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE (GENOTYPE & 2) = 0
  AND ((GENOTYPE & 1) > 0 OR (GENOTYPE & 4) > 0);