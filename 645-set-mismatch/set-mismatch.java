class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0, n = nums.length;
        while(i < n) {
            int correctIndex = nums[i] - 1;
            if(nums[correctIndex] != nums[i]) {
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != j + 1) {
                return new int[]{nums[j],j+1};
            }
        }
        return new int[]{};
    }
}