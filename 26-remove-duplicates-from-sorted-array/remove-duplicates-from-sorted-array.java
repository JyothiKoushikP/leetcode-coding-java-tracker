class Solution {
    public int removeDuplicates(int[] nums) {
        int element = nums[0];
        int position = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != element) {
                element = nums[i];
                int temp = nums[i];
                nums[i] = nums[position];
                nums[position] = temp;
                position++;
            }
        }
        
        return position;
    }
}