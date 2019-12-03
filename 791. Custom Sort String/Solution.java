class Solution {
    public String customSortString(String S, String T) {
        
        char[] ca=T.toCharArray(); //T문자열을 가지고 단어 배열로 변경 
        StringBuffer result= new StringBuffer(); // 결과값 저장할 버퍼 생성
    
        for(int i=0; i<S.length();i++){ // S문자열의 단어 하나씩을 T단어 배열에 있는지 찾음
            for(int j=0; j<ca.length;j++){ 
                if(S.charAt(i)==ca[j]){ // 단어가 있으면 이를 결과값 버퍼에 저장
                    result.append(ca[j]);
                    ca[j]='0';    // 그리고 매칭된 T 단어는 다른값으로 바꿈
                }
            }
        }
        for(int j=0; j<ca.length;j++){ 
            // 위 결과 S문자열을 추출 했고 T문자열에서 이를 뺀 나머지값을 결과값에 저장한다.
            if(ca[j]!='0'){
                result.append(ca[j]);
            }
        }
        return result.toString();
    }
}