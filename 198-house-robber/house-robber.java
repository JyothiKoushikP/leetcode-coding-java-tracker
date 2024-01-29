class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] cost = new int[nums.length];
        int[] maxArray = new int[nums.length];
        int maxValue = Integer.MIN_VALUE;

        for(int i = 0; i < 2; i++) {
            maxValue = Math.max(maxValue,nums[i]);
            maxArray[i] = maxValue;
        }

        for(int i = 2; i < nums.length; i++) {
            int costi = maxArray[i-2] + nums[i];
            cost[i] = costi;
            maxValue = Math.max(maxValue,costi);
            maxArray[i] = maxValue;
        }

        return maxValue;
    }
}