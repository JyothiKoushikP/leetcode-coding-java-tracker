class Solution {
    public int maxProfit(int[] prices) {
        int[] profit = new int[prices.length];

        int currMaxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            int maxPrice = 0;
            for(int j = 0; j < i; j++) {
                maxPrice = Math.max(maxPrice,(prices[i]- prices[j]) + (j-2 >= 0 ? profit[j-2]: 0));
            }
            currMaxProfit = Math.max(maxPrice,currMaxProfit);
            profit[i] = currMaxProfit;
        }

        return currMaxProfit;
    }
}
