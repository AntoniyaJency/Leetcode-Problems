class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];   // best buying price so far
        int maxProfit = 0;          // best profit so far

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];          // update buy price
            } else {
                int profit = prices[i] - minPrice;

                if (profit > maxProfit) {
                    maxProfit = profit;        // update max profit
                }
            }
        }
        return maxProfit;
    }
}
