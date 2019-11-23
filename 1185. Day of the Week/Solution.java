import java.util.Calendar;

class Solution {
    static final String[] week={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}; //요일을 나타내는 문자열 배열 생성
    
    public String dayOfTheWeek(int day, int month, int year) {
    
        Calendar c=Calendar.getInstance(); //calendar 객체 생성 ( 이 클래스는 추상 클래스라 new로 생성하지 않고 getInstance를 호출하여 생성한다.)
        
        //c.set(year,month-1,day); // 날짜 셋팅
        
        c.set(c.YEAR,year);
        c.set(c.MONTH,month-1);  //calendar 클래스에선 월의 시작이 숫자 0으로 시작하여 -1을 해줘야됌
        c.set(c.DAY_OF_MONTH,day);  // 일을 나타냄
        
        //System.out.println(c.getTime());
        int w=c.get(c.DAY_OF_WEEK); // 요일값을 가져옴 , 1은 일요일로 시작 ~ 7은 마지막 토요일
    
        return week[w-1];
    }
}