class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        
        String[] words=text.split(" "); //텍스트를 단어별로 나눈다.
        ArrayList<String> result=new ArrayList<String>(); //결과 저장할 리스트 생성
        
        String copy = first.concat(second); // 비교문장 만들기
        String s=null;
        
        for(int i=0; i<words.length-2; i++){
            s=words[i].concat(words[i+1]);  // 텍스트의 두 단어를 합친다. 
            if(s.equals(copy)){ //비교문장과 두 단어 합친것을 비교
              result.add(words[i+2]);  //같으면 다음 단어를 더해준다.
            }
        }
        return result.toArray(new String[result.size()]); //리스트를 배열로 변환
    }
}