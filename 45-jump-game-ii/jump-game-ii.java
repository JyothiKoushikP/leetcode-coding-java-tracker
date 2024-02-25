class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int steps = 0, maxPosition = 0, remJumps = 0;
        steps++;
        maxPosition = nums[0];
        remJumps = nums[0];
        for(int i = 1; i < nums.length - 1; i++) {
            remJumps--;
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if(remJumps == 0) {
                steps++;
                remJumps = maxPosition - i;
            }
        }
        return steps;
    }
}