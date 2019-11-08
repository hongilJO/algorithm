class Solution {
    
    public int[] splitWord(String word){   //문자열에서 숫자를 뽑는 함수 생성
        
        String[] string_numbers=word.split("\\+");  // + 기호 앞 뒤로 정수와 복소수 분리
        int[] numbers=new int[2]; // 정수와 복소수 저장하는 배열 생성
        numbers[0]=Integer.parseInt(string_numbers[0]); // 자연수 저장           
        numbers[1]=Integer.parseInt(string_numbers[1].substring(0,string_numbers[1].length()-1)); // 문자열 끝에 i를 뺀 숫자인 복소수 저장
        /*
        Integer.parseInt [int 반환] : 호출시 문자열 앞에 - 기호가 있을 경우 음수로 변환
        Integer.valueOf [Integer 객체 반환] : 호출시 문자열 앞에 -기호가 있어도 양의 정수로만 인식하여 양수로 변환
        */
        return numbers;
    }
    public String complexNumberMultiply(String a, String b) {
        int[] front=splitWord(a);
        int[] rear=splitWord(b);
        
        int natural=(front[0]*rear[0])+(front[1]*rear[1]*-1); // 정수값
        int complex=front[0]*rear[1]+front[1]*rear[0]; // 복소수값
        String result=natural+"+"+complex+"i";
        
        return result;
    }
}