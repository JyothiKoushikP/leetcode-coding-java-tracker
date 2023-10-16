class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = -1, maxIndex = -1;
        
        if(nums.length - indexDifference < 0) {
            return new int[]{-1,-1};
        }
        
        for(int i = 0;i < nums.length - indexDifference; i++) {
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
            if(nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
            if(Math.abs(nums[i + indexDifference] - max) >= valueDifference) {
                return new int[]{maxIndex,i + indexDifference};
            }
            if(Math.abs(nums[i + indexDifference] - min) >= valueDifference) {
                return new int[]{minIndex,i + indexDifference};
            }
        }
        return new int[]{-1,-1};
    }
}