class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int l = 0, r = 0;
        int sum = 0, prev = 0;
        while(r < nums.length) {
            if(left <= nums[r] && nums[r] <= right) {
                prev = (r - l) + 1;
                sum += prev;
            } else if(nums[r] < left) {
                sum += prev;
            } else {
                l = r + 1;
                prev = 0;
            }
            r++;
        }
        return sum;
    }
}