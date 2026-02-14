-- 랭크와 총 개수
-- 총 개수가 8개면 CRITICAL은 total * 0.25 = 2

SELECT ID,
    CASE
        WHEN R <= TOTAL * 0.25 THEN 'CRITICAL'
        WHEN R <= TOTAL * 0.50 THEN 'HIGH'
        WHEN R <= TOTAL * 0.75 THEN 'MEDIUM'
        WHEN R <= TOTAL * 1.00 THEN 'LOW'
    END AS COLONY_NAME
FROM (
        -- 각 행마다 각 랭크 포함
        SELECT 
            ID,
            RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS R,
            COUNT(*) OVER () AS TOTAL
        FROM ECOLI_DATA
    ) t
ORDER BY ID ASC;