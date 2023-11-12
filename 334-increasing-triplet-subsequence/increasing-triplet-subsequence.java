class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] mins = new int[n];
        int[] maxs = new int[n];
        mins[0] = Integer.MAX_VALUE;
        maxs[n-1] = Integer.MIN_VALUE;

        for(int i = 1; i < n; i++) {
            mins[i] = Math.min(mins[i-1],nums[i-1]);
        }

        for(int i = n-2; i >= 0; i--) {
            maxs[i] = Math.max(maxs[i+1],nums[i+1]);
        }

        for(int i = 1; i < n-1 ; i++) {
            if(mins[i] < nums[i] && nums[i] < maxs[i]) {
                return true;
            }
        }

        return false;
    }
}