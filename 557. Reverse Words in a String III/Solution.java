class Solution {
    public String reverseWords(String s) {
        String[] word=s.split(" "); // 문장을 단어로 분해
        StringBuffer sb=new StringBuffer(); //결과값 저장할 StringBuffer 생성
        
        for(int i=0; i<word.length;i++){
            sb.append(new StringBuffer(word[i]).reverse().toString()); // 풀이 1. SB 클래스의 reverse를 호출하여 단어를 역순으로 변경하여 더한다.
            /*
            for(int j=word[i].length()-1;j>=0;j--){ // 풀이2. 각 단어 끝에서부터 한개씩 더한다. 
                sb.append(word[i].substring(j,j+1));
            }*/
            
            if(i!=word.length-1){
               sb.append(" ");     //단어가 끝나면 공백 추가로 더함
            }
        }
        return sb.toString();
    }
}