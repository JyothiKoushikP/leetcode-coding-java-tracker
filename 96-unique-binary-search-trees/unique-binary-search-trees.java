class Solution {
    int[] dp;
    public int numTrees(int n) {
        dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n ; i++) {
            dp[i] = calculateDp(i);
        }
        return dp[n];
    }

    public int calculateDp(int n) {
        int lowerbound = 1, upperBound = n;
        int sum = 0;
        int i = 1;

        while(i <= upperBound) {
            sum += (dp[i-lowerbound] * dp[upperBound - i]);
            i++;
        }
        return sum;
    }
}