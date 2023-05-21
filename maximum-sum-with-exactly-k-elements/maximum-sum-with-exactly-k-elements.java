class Solution {
    public int maximizeSum(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i: nums) {
            max = Math.max(i,max);
        }
        int i = 0;
        while(i < k) {
            sum += max;
            max += 1;
            i++;
        }
        return sum;
    }
}