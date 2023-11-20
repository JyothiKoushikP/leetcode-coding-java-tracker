class Solution {
    public int trap(int[] nums) {
        int n = nums.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int m = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            m = Math.max(m,nums[i]);
            maxLeft[i] = m;
        }

        m = Integer.MIN_VALUE;
        for(int i = n-1; i >= 0; i--) {
            m = Math.max(m,nums[i]);
            maxRight[i] = m;
        }

        int area = 0;

        for(int i = 1; i < n-1; i++) {
            int min = Math.min(maxLeft[i-1],maxRight[i+1]);
            if(min > nums[i]) {
                area += (min - nums[i]);
            }
        }

        return area;
    }
}