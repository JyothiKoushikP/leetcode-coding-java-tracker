class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int window = Integer.MAX_VALUE, sum = 0;
        int start = 0;
        for(int i = 0;i < nums.length; i++) {
            sum += nums[i];
            if(sum >= target) {
                while(sum >= target){
                    window = Math.min(i-start+1,window);
                    sum -= nums[start++];
                } 
            }
        }
        return window == Integer.MAX_VALUE ? 0: window;
    }
}