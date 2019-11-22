class Solution {
    /*
    선택정렬로 구현 했지만 맨하탄 거리값 ( 즉 절대값이 작은거부터 차래대로 좌표를 결과 배열에 넣는 방법이 더 효과적일듯)
    */
    public int customAbs(int i, int j){
        int k=i-j;
        if(k > 0){
            return k;
        }else{
            return -k;
        }
    }
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        
        int size=R*C; // 생성할 전체 거리의 개수
        
        int[][] result=new int[size][2]; // 좌표값 저장할 배열
        int[] sumarr = new int[size]; // 맨하탄 거리값 저장할 배열
        int sum=0;
        int index=0;
        for(int i=0; i<R;i++){   // row, col을 하나씩 증가시키면서 좌표 생성
            for(int j=0; j<C;j++){
                sum= customAbs(r0,i) + customAbs(c0,j); // 좌표별 맨하탄 거리값 구함
                sumarr[index]=sum; 
                result[index][0]=i; //좌표 row
                result[index][1]=j; //좌표 col
                index++;
            }            
        }
        
        for(int k=0; k<size-1;k++){  //맨하탄 거리 작은값부터 오름차순으로 정렬 (여기선 선택정렬 구현)
            int temp=0;
            int temp0=0;
            int temp1=0;
            for(int l=k+1; l<size;l++){
                if(sumarr[k]>sumarr[l]){  // 최소값부터 찾아서 하나씩 교환
                   
                    temp=sumarr[l];    //맨하탄거리값 이동
                    sumarr[l]=sumarr[k];
                    sumarr[k]=temp;
                    
                    temp0=result[l][0];  //좌표값 이동
                    temp1=result[l][1];
                    result[l][0]=result[k][0];
                    result[l][1]=result[k][1];
                    result[k][0]=temp0;
                    result[k][1]=temp1;
                }
            }
        }
        return result;   
    }
}
