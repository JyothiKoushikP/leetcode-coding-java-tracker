class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int maxJumps = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(maxJumps >= i) {
                maxJumps = Math.max(i + nums[i],maxJumps);
                nums[i] = maxJumps;
            } else {
                maxJumps = 0;
            }
        }
        
        return maxJumps >= nums.length - 1;
    }
}