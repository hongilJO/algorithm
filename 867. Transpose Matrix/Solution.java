class Solution {
    public int[][] transpose(int[][] A) {
        int[][] B = new int[A[0].length][A.length]; // 전치된 행렬 생성
        
        for(int i=0; i<A.length;i++){ //원래 행렬에서 행과 열을 변경하여 전치행렬 값에 저장
            for(int j=0; j<A[i].length;j++){ 
                B[j][i]=A[i][j];   
            }
        }
        return B;
    }
}