class Solution {
    public int maximumSwap(int num) {
        int digits = (int)(Math.log10(num) + 1);
        if(num == 0) return 0;
        int[] nums = new int[digits];
        int[] mins = new int[digits];
        int[] maxs = new int[digits];

        int pointer = digits - 1;   
        while(num > 0) {
            nums[pointer--] = num % 10;
            num /= 10;
        }
        
        int minIndex = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(min > nums[i]) {
                min = nums[i];
                minIndex = i;
            }
            mins[i] = minIndex;
        }

        int maxIndex = digits-1, max = Integer.MIN_VALUE;
        for(int i = digits - 1; i >= 0; i--) {
            if(max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
            maxs[i] = maxIndex;
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[mins[i]] <= nums[i] && nums[i] < nums[maxs[i]]) {
                int temp = nums[i];
                nums[i] = nums[maxs[i]];
                nums[maxs[i]] = temp;
                break;
            }
        }

        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result = (result * 10) + nums[i];
        }
        
        return result;
    }
}