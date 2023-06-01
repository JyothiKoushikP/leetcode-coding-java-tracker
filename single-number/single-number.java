class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length, x = nums[0];
        for(int i = 1; i < n; i++) {
            x ^= nums[i];
        }
        return x;
    }
}