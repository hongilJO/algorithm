class Solution {
    public boolean valueCheck(HashMap<String,String> hs, String value){
        for(String s:hs.values()){
            if(s.equals(value)){
                return false;
            }
        }
        return true;
    }
    public boolean isIsomorphic(String s, String t) {
        HashMap<String,String> hs=new HashMap<>(); //두 단어에서 대칭되는 문자를 저장할 해쉬맵 생성        
        for (int i=0; i<s.length();i++){  // 루프를 돌면서 각각의 문자가 해쉬맵에 있는지 체크
            if(hs.get(s.substring(i,i+1))==null){  // 해쉬맵에 없으면 삽입
                if(valueCheck(hs,t.substring(i,i+1))){ // 삽입시 기존에 삽입한 중복된값인지 체크(에러검출) 
                    hs.put(s.substring(i,i+1),t.substring(i,i+1));
                }else{
                    return false;
                }
            }
            else{  // 해쉬맵에 있는 문자이면 
                String v=hs.get(s.substring(i,i+1)); // 해쉬맵에서 뽑은뒤 비교할 문자와 같은지 체크
                if(!v.equals(t.substring(i,i+1))){
                    return false;
                }
            }
        }
        return true;
    }
}