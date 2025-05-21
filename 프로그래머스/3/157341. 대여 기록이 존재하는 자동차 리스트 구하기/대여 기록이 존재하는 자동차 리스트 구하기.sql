-- 코드를 입력하세요
SELECT DISTINCT h.car_id
FROM CAR_RENTAL_COMPANY_CAR c JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY h ON c.car_id=h.car_id
WHERE h.start_date >="2022-10-01" AND h.start_date<="2022-10-31" AND c.car_type="세단"
ORDER BY h.car_id desc;