class Solution {
    public int maxProfit(int[] prices) {
       int currentMin = prices[0];
       int maxProfit = 0;
       for(int i = 1; i < prices.length; i++) {
           if(prices[i] > currentMin) {
               maxProfit = Math.max(maxProfit,prices[i] - currentMin);
           } else {
               currentMin = prices[i];
           }
       }
        return maxProfit;
    }
}