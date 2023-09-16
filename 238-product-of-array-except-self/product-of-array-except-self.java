class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        int[] suffix = new int[n+1];
        prefix[0] = 1;
        suffix[n] = 1;
        int product = 1;
        for(int i = 1;i < n;i++) {
            product *= nums[i-1];
            prefix[i] = product;
        }
        product = 1;
        for(int i = n-1;i>=0;i--){
            product *= nums[i];
            suffix[i] = product;
        }
        for(int i = 0;i < n;i++) {
            nums[i] = prefix[i] * suffix[i+1];
        }

        return nums;
    }
}