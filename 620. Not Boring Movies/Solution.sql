# 나머지를 구하는 MOD 함수를 적용하는게 직접 계산하는것 보다 결과값이 빠르다.

#select * from cinema where id%2=1 and description !='boring' order by rating desc; 

select * from cinema where mod(id,2)=1 and description !='boring' order by rating desc; 