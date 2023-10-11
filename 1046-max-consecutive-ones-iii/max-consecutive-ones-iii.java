class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, left = 0, zeros = 0, maxLen = 0;
        for(int right = 0; right < n; right++) {
            if(nums[right] == 0) zeros++;
            if(zeros > k) {
                while(zeros > k) {
                    if(nums[left] == 0) zeros--;
                    left++;
                }
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}