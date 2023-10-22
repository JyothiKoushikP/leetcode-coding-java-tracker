class Solution {
    
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] minLeft = new int[n];
        int[] minRight = new int[n];

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                minLeft[i] = nums[i];
            } else {
                minLeft[i] = Math.min(minLeft[i-1],nums[i-1]);
            }
        }

        for(int i = n-1; i >= 0; i--) {
            if(i == n-1) {
                minRight[i] = nums[i];
            } else {
                minRight[i] = Math.min(minRight[i+1],nums[i+1]);
            }
        }

        int minSum = Integer.MAX_VALUE;
        for(int i = 1; i < n-1; i++) {
            if(nums[i] > minLeft[i] && nums[i] > minRight[i]) {
                minSum = Math.min(minLeft[i] + minRight[i] + nums[i],minSum);
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}