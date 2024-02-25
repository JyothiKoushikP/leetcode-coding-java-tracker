class Solution {
    public int maxProfit(int[] prices) {
        int currentPrice = -1;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(currentPrice == -1) {
                currentPrice = prices[i];
            } else {
                maxProfit = maxProfit + ((currentPrice < prices[i]) ? (prices[i] - currentPrice) : 0);
                currentPrice = prices[i];
            }
        }
        return maxProfit;
    }
}