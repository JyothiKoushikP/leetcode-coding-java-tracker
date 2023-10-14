class NumArray {
    int[] result;
    public NumArray(int[] nums) {
        result = new int[nums.length];
        int prefixSum = 0;
        for(int i = 0; i < result.length; i++) {
            prefixSum += nums[i];
            result[i] = prefixSum;
        }
        System.out.println(Arrays.toString(result));
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) {
            return result[right];
        } else {
            return result[right] - result[left-1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */