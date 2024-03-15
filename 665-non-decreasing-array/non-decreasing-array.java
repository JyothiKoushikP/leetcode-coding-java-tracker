class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length == 0) return true;
        int minVal = nums[nums.length - 1];
        int count1 = 0;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] > minVal) {
                count1++;
            }
            minVal = Math.min(minVal, nums[i]);
        }
        int count2 = 0;
        int maxVal = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < maxVal) {
                count2++;
            }
            maxVal = Math.max(maxVal,nums[i]);
        }

        return Math.min(count1,count2) <= 1;
    }
}