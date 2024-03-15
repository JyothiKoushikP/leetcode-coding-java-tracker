class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int i = Integer.compare(o1[0],o2[0]);

                if(i == 0) {
                    return Integer.compare(o1[1],o2[1]);
                }
                return i;
            }
        });
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        for(int i = 1; i < pairs.length; i++) {
            int maxCount = 1;
            for(int j = 0; j < i; j++) {
                if(pairs[i][0] > pairs[j][1]) {
                    maxCount = Math.max(maxCount, dp[j] + 1);
                }
            }
            dp[i] = maxCount;
        }
        return dp[pairs.length - 1];
    }
}