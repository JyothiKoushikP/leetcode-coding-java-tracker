/*
TC: O(n2)
SC: O(1)
Approach: for every index, store the count of the longest increasing subsequence and increase
it along the way, keep a currMax to track it and when you are done, just return the map.get(currMax)
*/

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int currMax = 1;
        Map<Integer,Integer>[] count = new HashMap[nums.length];
        Map<Integer,Integer> cum = new HashMap<>();
        int[] dp = new int[nums.length];
        dp[0] = 1;
        if(count[0] == null) {
            count[0] = new HashMap<>();
            count[0].put(1,1);
            cum.put(1,1);
        }
        for(int i = 1; i < nums.length; i++) {
            int maxLen = 1;
            if(count[i] == null) {
                count[i] = new HashMap<>();
                count[i].put(1,1);
                cum.put(1,cum.getOrDefault(1,0) + 1);
            }
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    count[i].put(dp[j] + 1,count[i].getOrDefault(dp[j]+1,0) + count[j].get(dp[j]));
                    cum.put(dp[j] + 1,cum.getOrDefault(dp[j] + 1,0) + count[j].get(dp[j]));
                    maxLen = Math.max(maxLen,dp[j] + 1);
                }
            }
            dp[i] = maxLen;
            currMax = Math.max(maxLen,currMax);
        }
        return cum.get(currMax);
    }
}