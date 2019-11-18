class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        
        //결국엔 못풀어서 솔루션봤네 ㅠㅠ
        
        ArrayList<int []> ans = new ArrayList(); // 결과값 저장할 리스트
        
        int i = 0, j = 0;  //i는 A의 인덱스, j는 B의 인덱스
        
         while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i][0], B[j][0]); // A와 B의 첫번째 값중 큰값을 공통의 최저값으로 지정
            int hi = Math.min(A[i][1], B[j][1]); // A와 B의 두번째 값중 작은값을 공통의 최대값으로 지정
            if (lo <= hi){            // 공통의 최저값이 공통의 최대값을 넘어선 안된다.
                int [] temp={lo,hi};
                ans.add(temp);
            }
            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1]){  //A와 B의 두번째 값중 작은값의 인덱스를 올린다.
                i++;
            }
            else{
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}