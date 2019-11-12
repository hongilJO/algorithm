class Solution {
    public boolean divisorGame(int N) {
        
        int turn=0; // 1 은 alice , 0은 bob 이 이긴거를 나타냄
        while(N!=1){
            for(int i=1; i<N ;i/=1){
                N=N-i;  // 0과 N 사이의 정수값이면서 나눴을때 나머지가 0인 수 (최소값은 1)
                turn++; // 1씩 빼면서 alice와 bob이 서로 턴을 넘기는걸 나타냄
            }
        }
        
        if(turn%2==1){
            return true;   // 결과 alice 턴으로 끝나면 true, bob턴으로 끝나면 false
        }else{
            return false;
        }
        
    }
}