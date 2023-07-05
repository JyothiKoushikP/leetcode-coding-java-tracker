class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        int[] suffix = new int[n+1];
        int[] arr = new int[n];

        int prefixSum = 0;
        for(int i = 1; i < prefix.length; i++) {
            prefixSum += nums[i-1];
            prefix[i] = prefixSum;
        }

        int suffixSum = 0;
        for(int i = n-1; i >= 0; i--) {
            suffixSum += nums[i];
            suffix[i] = suffixSum;
        }

        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            int sum1 = suffix[i] - ((n-i) * nums[i]);
            int sum2 = (i * nums[i]) - prefix[i];
            result[i] = sum1 + sum2;
        }

        return result;
    }
}