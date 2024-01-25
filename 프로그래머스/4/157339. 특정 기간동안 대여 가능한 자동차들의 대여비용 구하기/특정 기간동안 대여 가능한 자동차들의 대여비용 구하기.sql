select a.CAR_ID, a.CAR_TYPE, round(a.DAILY_FEE*30*((100-b.DISCOUNT_RATE)/100))as fee
from CAR_RENTAL_COMPANY_CAR as a 
    join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as b
on a.CAR_TYPE = b.CAR_TYPE
where b.DURATION_TYPE='30일 이상'
    and (a.CAR_TYPE='SUV' or a.CAR_TYPE='세단')
    and a.DAILY_FEE*30*((100-b.DISCOUNT_RATE)/100) >= 500000
    and a.DAILY_FEE*30*((100-b.DISCOUNT_RATE)/100) <= 2000000
    and a.CAR_ID not in (
        select CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where START_DATE <= '2022-11-30' AND END_DATE >= '2022-11-01'
    )
order by fee DESC, a.CAR_TYPE ASC, a.CAR_ID DESC

