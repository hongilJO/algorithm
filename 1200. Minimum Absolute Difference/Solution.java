class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        ArrayList<List<Integer>> al= new ArrayList<>(); // 결과값 저장할 리스트생성
        
        Arrays.sort(arr); // 배열 값 오름차순 정렬
        int low=100000; // 최저값 디폴트 지정
        for(int i=0; i<arr.length-1; i++){
            int solve=0; // 다음값 - 현재값 저장
            if(arr[i]-arr[i+1]<0){  // 음수일때
                solve=-(arr[i]-arr[i+1]);
            }else{    //양수일때
                solve=arr[i]-arr[i+1];
            }
            
            if(low==solve){  // 이전에 나온 최저값과 위에서 계산한 값을 비교하여 같으면 저장한다.
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                al.add(temp);
            }else if(low>solve){ // 최저값보다 작은값일 경우 기존값을 모두 지우고 지금값 넣어줌
                al.clear();
                low=solve;
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                al.add(temp);
            }
        }
        return al;
    }
}