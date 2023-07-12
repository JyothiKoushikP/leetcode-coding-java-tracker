class Solution {
    public int hIndex(int[] citations) {
        int max = Integer.MIN_VALUE;
        for(int i: citations) {
            max = Math.max(i,max);
        }
        int[] nums = new int[max + 1];

        for(int i = 0; i < citations.length; i++) {
            nums[citations[i]]++;
        }

        int sum = 0;

        for(int i = max; i>= 0; i--) {
            sum += nums[i];
            nums[i] = sum;
        }

        for(int i = max; i >= 0; i--) {
            if(nums[i] >= i){
                return i;
            }
        }

        return 0;
    }
}