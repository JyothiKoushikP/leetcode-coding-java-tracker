class Solution {
    public int maxProfit(int[] prices) {
        int[] res = new int[prices.length];
        res[0] = Integer.MIN_VALUE;
        for(int i=1;i<res.length;i++){
            res[i] = prices[i] - prices[i-1];
        }
        int sum = 0;
        int max = 0;
        for(int i=1;i<res.length;i++){
            sum += res[i];
            max = Math.max(sum,max);
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}