class Solution {
    public int maxProfit(int[] prices) {
        /*
        int max=0;
        for(int i=0; i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){  // 전체 모든 값을 비교한다.
                if(max<prices[j]-prices[i]){
                    max=prices[j]-prices[i];
                }
            }
        }
        return max;
        */
        int sell=0;    //팔때 나타내는 최고값
        int buy=Integer.MAX_VALUE;    //살때 나타내는 최저값
        
        for(int i=0; i<prices.length;i++){ //전체 값을 순차적으로 접근하면서
            if(buy>prices[i]){
                buy=prices[i];  // 기존 최저값보다 낮은값일경우 대입
            }
            else{
                if(sell < (prices[i]-buy)){ //최저값보다 높을경우 시세차익 계산
                    sell=prices[i]-buy; // 시세차익이 높으면 대입
                }
            }
        }
        return sell;
    }
}