class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int mins[] = new int[n + 1];
        int maxs[] = new int[n + 1];
        maxs[0] = Integer.MIN_VALUE;
        mins[n] = Integer.MAX_VALUE;
        
        int maxNum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(nums[i] >= maxNum){
                maxNum = nums[i];
            }
            maxs[i+1] = maxNum;
        }

        int minNum = Integer.MAX_VALUE;
        for(int i = n-1; i >= 0; i--) {
            if(nums[i] <= minNum){
                minNum = nums[i];
            }
            mins[i] = minNum;
        }

        boolean[] res = new boolean[n];

        for(int i = 0; i < n; i++) {
            if((maxs[i] > nums[i]) || (mins[i+1] < nums[i]))
                res[i] = true;
        }

        int start = -1, i = 0;
        while(i < n){
            if(res[i]) {
                start = i;
                break;
            }
            i++;
        }
        
        if(start == -1) return 0;
        
        int end = n;
        i = n-1;
        while(i >= 0){
            if(res[i]) {
                end = i;
                break;
            }
            i--;
        }

        if(end == n) return 0;

        return (end - start) + 1;
    }
}