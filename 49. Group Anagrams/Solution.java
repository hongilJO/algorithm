class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> store= new HashMap<>();//  그룹별 분류(키)를 저장할 해쉬맵 생성
        
        for(int i=0; i<strs.length;i++){ // 단어들의 루프를 돌면서
            int[] alphabet=new int[26];  // 각각 단어의 문자개수를 알파벳 배열에 카운트하여 저장 
            for(int j=0; j<strs[i].length();j++){
                int index=strs[i].charAt(j)-'a'; 
                alphabet[index]++;
            }
            String s=Arrays.toString(alphabet); // 저장한 알파벳 배열을 문자열화
            if(store.get(s)==null){  // 해쉬맵에 알파벳 배열 문자열이 없으면
                List<String> group=new ArrayList<>(); // list 생성 후 해당 문자열 저장 (그룹생성)
                group.add(strs[i]);
                store.put(s,group); // 해쉬맵에 list삽입
            }else{
                List<String> group=store.get(s); //해쉬맵에 알파벳 배열 문자열이 있으면
                group.add(strs[i]);  // 문자열이 같다는 것은 같은 단어로 이뤄졌다는것 -> 같은 그룹
            }                        // 따라서 리스트에 추가한다.
        }
        return new ArrayList<List<String>>(store.values()); //hashmap의 values는 저장된값의 리스트를 반환 
    }
}