-- 코드를 입력하세요
SELECT
    COUNT(A.COUNT)
FROM
    (SELECT
        COUNT(*) AS COUNT
    FROM
        ANIMAL_INS
    WHERE
        NAME IS NOT NULL
    GROUP BY
        NAME) AS A;