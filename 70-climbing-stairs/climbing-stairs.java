class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1; dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            int sum = dp[i-2] + dp[i-1];
            dp[i] = sum;
        }
        return dp[n];
    }
}