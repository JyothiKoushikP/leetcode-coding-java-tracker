class Solution {
    public int removeDuplicates(int[] nums) {
        int position = 1;
        int element = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != element) {
                element = nums[i];
                int temp = nums[position];
                nums[position] = nums[i];
                nums[i] = temp;
                position++;
            }
        }
        return position;
    }
}