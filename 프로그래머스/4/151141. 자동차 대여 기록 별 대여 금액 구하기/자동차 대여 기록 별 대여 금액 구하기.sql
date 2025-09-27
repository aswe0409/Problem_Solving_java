SELECT H.HISTORY_ID,
       CASE
         WHEN H.END_DATE - H.START_DATE + 1 >= 90 
              THEN C.DAILY_FEE * (1 - (SELECT DISCOUNT_RATE 
                                        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                                        WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '90일 이상')/100)
                   * (H.END_DATE - H.START_DATE + 1)
         WHEN H.END_DATE - H.START_DATE + 1 >= 30 
              THEN C.DAILY_FEE * (1 - (SELECT DISCOUNT_RATE 
                                        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                                        WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '30일 이상')/100)
                   * (H.END_DATE - H.START_DATE + 1)
         WHEN H.END_DATE - H.START_DATE + 1 >= 7 
              THEN C.DAILY_FEE * (1 - (SELECT DISCOUNT_RATE 
                                        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                                        WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '7일 이상')/100)
                   * (H.END_DATE - H.START_DATE + 1)
         ELSE C.DAILY_FEE * (H.END_DATE - H.START_DATE + 1)
       END AS FEE
FROM CAR_RENTAL_COMPANY_CAR C
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H 
  ON C.CAR_ID = H.CAR_ID
WHERE C.CAR_TYPE = '트럭'
ORDER BY FEE DESC, H.HISTORY_ID DESC;
