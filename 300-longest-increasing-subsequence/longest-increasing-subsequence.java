class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] track = new int[nums.length];
        for(int i = 1; i < nums.length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) max = Math.max(max,track[j] + 1);
            }
            track[i] = max;
        }
        int maxSubsequenceLength = 0;
        for (int num : track) {
            maxSubsequenceLength = Math.max(num, maxSubsequenceLength);
        }
        return maxSubsequenceLength + 1;
    }
}