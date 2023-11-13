class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return targetSum(nums,0,target,0);
    }

    public static int targetSum(int[] nums, int curSum, int targetSum, int pointer) {
        if(pointer == nums.length) {
            if(curSum == targetSum){
                return 1;
            } else {
                return 0;
            }
        }
        int i = nums[pointer];
        int left = targetSum(nums,curSum - i,targetSum,pointer + 1);
        int right = targetSum(nums,curSum + i,targetSum,pointer + 1);

        return left + right;
    }
}