class Solution {
    public List<String> commonChars(String[] A) {
        ArrayList<String> result=new ArrayList<>();
        
        for(int l=0; l<A[0].length();l++){
            result.add(A[0].substring(l,l+1));   // 맨 처음 문자열을 문자로 변경하여 결과값 리스트에 저장
        }
        int index=1; // 결과값과 비교할 문자열의 순서를 나타내는 인덱스 
        
        while(index<A.length){
            ArrayList<String> temp=new ArrayList<>(); 
            for(int l=0; l<A[index].length();l++){
                temp.add(A[index].substring(l,l+1));  // 비교할 문자열을 문자로 변경하여 비교값 리스트에 저장 
            }
            for(int i=0; i<result.size();i++){  // 결과값 리스트의 문자를 하나씩 뽑아서 비교값 리스트의 모든 문자와 비교
                boolean check=false;
                for(int j=0; j<temp.size();j++){
                    if(result.get(i).equals(temp.get(j))){  
                        temp.remove(j);
                        check=true; // 똑같은게 있으면 비교값에 있는 단어를 지우고 다음 결과값 단어로 넘어감
                        break;
                    }
                }
                if(check==false){
                    result.remove(i);// 똑같은게 없으면 결과값 단어를 지운다.
                    i--;
                }
            }
            index++;  // 다음 문자열을 비교하기 위해 인덱스 값을 증가시킴
        }
        return result;
    }
}