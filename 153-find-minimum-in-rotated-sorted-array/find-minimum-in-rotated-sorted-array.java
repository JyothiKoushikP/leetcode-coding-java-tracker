class Solution {
    public int findMin(int[] nums) {
        if(nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        int i = findStartingPivot(nums);
        return nums[i];
    }

    public int findStartingPivot(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] >= nums[0]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

}