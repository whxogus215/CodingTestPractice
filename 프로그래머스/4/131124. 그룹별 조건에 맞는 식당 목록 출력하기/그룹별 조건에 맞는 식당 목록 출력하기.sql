-- 코드를 입력하세요
SELECT
    MEMBER_NAME,
    REVIEW_TEXT,
    DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') as 'REVIEW_DATE'
FROM MEMBER_PROFILE as M
JOIN REST_REVIEW as R ON M.MEMBER_ID = R.MEMBER_ID
WHERE M.MEMBER_ID = (SELECT
                        MEMBER_ID
                      FROM REST_REVIEW
                      GROUP BY (MEMBER_ID)
                      ORDER BY (COUNT(MEMBER_ID)) DESC
                      LIMIT 1
                     )
ORDER BY REVIEW_DATE ASC, REVIEW_TEXT ASC;