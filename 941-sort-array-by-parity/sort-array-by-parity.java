class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int even = 0;
        for(int i: nums) {
            if(i % 2 == 0) even++;
        }
        int pointer = nums.length - 1, i = 0;
        while(i < nums.length && even != 0) {
            if(nums[i] % 2 == 0) {
                even--;
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[pointer];
                nums[pointer] = temp;
                pointer--;
            }
        }
        return nums;
    }
}