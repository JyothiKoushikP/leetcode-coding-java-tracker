class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
       int[] prefix = new int[nums.length];
       int[] suffix = new int[nums.length];

        int pr = 1;
        for(int i = 0; i < nums.length; i++) {
            pr *= nums[i];
            prefix[i] = pr;
            if(pr == 0) pr = 1;
        }
        pr = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            pr *= nums[i];
            suffix[i] = pr;
            if(pr == 0) pr = 1;
        }
        int mP = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 1; i++) {
            mP = Math.max(mP,prefix[i]);
            mP = Math.max(mP,suffix[i+1]);
            mP = Math.max(mP,prefix[i] * suffix[i+1]);
        }
        return mP;
    }
}