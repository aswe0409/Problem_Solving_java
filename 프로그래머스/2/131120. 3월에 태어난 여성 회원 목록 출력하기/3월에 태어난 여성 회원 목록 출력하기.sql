-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER,  DATE_FORMAT(DATE_OF_BIRTH,"%Y-%m-%d")
FROM MEMBER_PROFILE
WHERE DATE_OF_BIRTH LIKE "%-03-%" and TLNO IS NOT NULL and gender = 'W'