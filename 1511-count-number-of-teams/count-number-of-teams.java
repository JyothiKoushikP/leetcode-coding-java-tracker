class Solution {
    public int numTeams(int[] rating) {
        int count = 0;
        int[] dp = new int[rating.length];

        for(int i = 1; i < rating.length; i++) {
            int maxLen = 0;
            for(int j = 0; j < i; j++) {
                if(rating[i] > rating[j]) {
                    dp[i]++;
                    count += dp[j];
                }
            }
        }

        Arrays.fill(dp,0);

        for(int i = 1; i < rating.length; i++) {
            int maxLen = 0;
            for(int j = 0; j < i; j++) {
                if(rating[i] < rating[j]) {
                    dp[i]++;
                    count += dp[j];
                }
            }
        }

        return count;
    }
}