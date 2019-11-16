class Solution {
    public int smallestRangeI(int[] A, int K) {
       
        Arrays.sort(A); // 우선 숫자가 들어있는 배열을 정렬
        int result; // 결과값 들어갈 변수생성
        /*
        int index=0;
        while(index<=K){
            int max=A[A.length-1]-index;
            int low=A[0]+index;
            
            if(max-low<result){
                result=max-low;
            }
            if(result<0){
                result=0;
                break;
            }
    
            index++;
        }*/
        
        int max=A[A.length-1]-K;  //최대값에서 MAX(K)값을 빼주어 결과 B의 최대 최소 차이를 줄인다.
        int min=A[0]+K;   // 최소값에서 MIN(K)을 더해주어 결과 B의 최대 최소 차이를 줄인다.
        
        if(max-min>0){
            result=max-min; // 결과 B의 최대 최소가 겹치지 않는 경우
        }else{
            result=0;  //결과 B의 최대 최소가 겹칠 경우
        }
        return result;
        
    }
}