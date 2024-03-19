class Solution {
    public int numSquares(int n) {
        int prev = -1, curr = -1;
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        int[] squares = new int[101];
        for(int i = 1; i < squares.length; i++) {
            squares[i] = i * i;
        }

        for(int i = 1; i <= n; i++) {
            if(perfectSquare(i)) {
                dp[i] = 1;
            } else {
                for(int j = 1; j < squares.length && squares[j] < i; j++) {
                    dp[i] = Math.min(dp[i],dp[i - squares[j]] + dp[squares[j]]);
                }
            }
        }
        return dp[dp.length-1];
    }

    public boolean perfectSquare(int num) {
        double sqrt = Math.sqrt(num);
        return ((sqrt - Math.floor(sqrt)) == 0);
    }
}