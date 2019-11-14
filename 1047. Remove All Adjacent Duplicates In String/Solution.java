class Solution {
    public String removeDuplicates(String S) {
        
        Stack<String> stack = new Stack<String>();  //자료구조 stack 생성
        StringBuffer result =new StringBuffer();    //결과값 저장할 문자열 버퍼 생성
        for(int i=0; i< S.length(); i++){
            if(stack.isEmpty() || !stack.peek().equals(S.substring(i,i+1))){
                //값이 없거나 스택 맨위의 값이 다른 값 일때 문자 삽입
                stack.push(S.substring(i,i+1));
            }else if(stack.peek().equals(S.substring(i,i+1))){
                //스택 맨위의 값과 값이 같을때 문자 방출
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            //중복 제거된 값들 스택에서 뺀 다음 역 정렬 한번 해준다.
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}