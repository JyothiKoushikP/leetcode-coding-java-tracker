class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int count = 0, start = 0, pro = 1;
        for(int i = 0; i < nums.length; i++) {
            pro *= nums[i];
            while(pro >= k) {   
                pro /= nums[start++];
            }
            count += i - start + 1;
        }
        return count;
    }
}