class Solution {
    public int[] shortestToChar(String S, char C) {
        
        int[] result=new int[S.length()]; //결과값 저장할 배열생성
        
        for(int k=0;k<result.length;k++){
            result[k]=10000;    // 배열 초기화 작업
        }
        for(int i=0; i<S.length();i++){  // 전체 문자열 탐색
            if(S.charAt(i)==C){  // 맨 앞 문자열에서부터 찾을 문자랑 같은거 발견하면 
                for(int j=0;j<S.length();j++){  // 같은 문자 발견한 위치에서 전체 문자의 거리를 구하는데
                    if(result[j]>i-j){    // 값이 작을 경우에만 대입한다.
                        result[j]=Math.abs(i-j);  // 절대값을 넣어야됌 (안그럼 음수들어감).
                    }
                }
            }
        }
        return result;
    }
}