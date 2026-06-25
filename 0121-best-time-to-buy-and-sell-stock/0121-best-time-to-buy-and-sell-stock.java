class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int diff=prices[0];
        
        for(int i=1;i<prices.length;i++){
            if(prices[i]<diff) diff=prices[i];
            else{
                profit=Math.max(prices[i]-diff,profit);

            }
        }

        return profit;
    }
}