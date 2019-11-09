class Solution {
    public int[] countBits(int num) {
        int[] result=new int[num+1];
        /*
        for(int i=0; i<=num;i++){
            String bit=Integer.toBinaryString(i); // 정수를 이진수로 변환
            // new Integer(i); 이것은 int -> Integer 객체 생성
            int count=0;
            for(int j=0; j<bit.length();j++){
                if(bit.charAt(j)=='1')count++;  // 1인 숫자를 세서 넣어준다.
            }
            result[i]=count;
        }
        */
        //  i     0    1    2     3     4      5      6      7
        // bit    0    1    10    11    100    101    110    111
        
        if(num==0){
            result[0]=0;       // 0일때는 0
        }else if(num==1){
            result[0]=0;
            result[1]=1;       // 1일때는 0,1
        }else{
            result[0]=0;       // 2이상부터는 패턴이 반복된다.
            result[1]=1;
            for(int i=2; i<=num;i++){
                result[i]= i % 2==0 ? result[i/2] : result[i/2]+1; 
            }
        }
        return result;
    }
}