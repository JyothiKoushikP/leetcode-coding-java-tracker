class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer> stock = new Stack<Integer>();
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(stock.isEmpty()) {
                stock.push(prices[i]);
            } else {
                int price = stock.pop();
                maxProfit = maxProfit + ((price < prices[i]) ? (prices[i] - price) : 0);
                stock.push(prices[i]);
            }
        }
        return maxProfit;
    }
}