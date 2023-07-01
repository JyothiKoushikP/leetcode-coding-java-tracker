class Solution {
    public int longestOnes(int[] nums, int k) {
        int numberOfZeros = 0;
        int start = 0, max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                numberOfZeros++;
            }
            if(numberOfZeros > k) {
                while(numberOfZeros > k){
                    if(nums[start] == 0){
                        numberOfZeros--;
                    }
                    start++;
                }
            } else {
                max = Math.max(max,(i-start)+1);
            }
        }
        max = Math.max(max,((nums.length-1)-start)+1);
        return max;
    }
}