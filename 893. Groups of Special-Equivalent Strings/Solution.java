class Solution {
    public int numSpecialEquivGroups(String[] A) {
        
        /*
        문자 위치가 바껴도 개수는 같다는것을 이용한 알고리즘 풀이 
        */
        HashSet<String> hset= new HashSet<>(); // 결과값 저장할 set 설정
        
        for(int i=0; i<A.length;i++){
            int[] arr = new int[52]; // 홀수/짝수 위치의 알파벳 26개씩 개수 
            for(int j=0; j<A[i].length();j++){ //문자열 1개씩
                int num=(A[i].charAt(j)-'a')+(26*(j%2)); // 홀수 짝수 위치 알파벳 count 증가 
                arr[num]++;
            }
            String s=Arrays.toString(arr); //int형 배열 문자열로 변경
            System.out.println(s);
            hset.add(s); // 변경된 문자열 셋에 저장
        }
        return hset.size();
    }
}