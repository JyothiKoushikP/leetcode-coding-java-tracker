class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0; dp[1] = 0;
        for(int i = 2; i <= cost.length; i++) {
            int minCost1 = dp[i-1] + cost[i-1];
            int minCost2 = dp[i-2] + cost[i-2];
            dp[i] = Math.min(minCost1,minCost2);
        }
        return dp[cost.length];
    }
}