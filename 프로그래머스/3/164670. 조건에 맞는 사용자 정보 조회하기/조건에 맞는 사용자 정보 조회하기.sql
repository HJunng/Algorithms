-- 코드를 입력하세요
select 
    a.USER_ID, 
    a.NICKNAME, 
    concat(a.city,' ',a.STREET_ADDRESS1,' ',a.STREET_ADDRESS2) as 전체주소, 
    concat(substring(a.TLNO,1,3),'-',substring(a.TLNO,4,4),'-',substring(a.TLNO,8,4)) as 전화번호
from USED_GOODS_USER as a join (
    select writer_id, count(board_id) as count 
    from USED_GOODS_BOARD 
    group by writer_id
    having count>=3
) as b
on a.user_id = b.writer_id
order by a.user_id desc;