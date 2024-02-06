class Solution {
    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n+1];
        dp[1] = false;
        for(int i = 2; i <= n; i++) {
            int nums = i;
            for(int j = 1; j < i; j++) {
                if(i % j == 0) {
                    nums = i - j;
                    dp[i] = dp[i] || !dp[nums];
                }
            }
        }
        return dp[n];
    }
}