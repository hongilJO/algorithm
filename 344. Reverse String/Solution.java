class Solution {
    public void reverseString(char[] s) {
        
        int front=0;  // 앞의인덱스 값 나타낼 변수 설정
        
        while(front<(s.length-1)-front){      //앞과 뒤에서부터 하나씩 인덱스를 줄여가며 배열 값을 치환해줌 
            char temp=s[(s.length-1)-front];  //앞 뒤 인덱스가 중간에 교차할때까지 반복함 
            s[(s.length-1)-front]=s[front];
            s[front]=temp;
            front++;
        }
    }
}
