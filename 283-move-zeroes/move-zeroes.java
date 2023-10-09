class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1) {
            return;
        }
        int p1 = 0, p2 = 1, n = nums.length;
        while(p2 < n) {
            if(nums[p1] == 0) {
                if(nums[p2] != 0) {
                    swap(nums,p1,p2);
                    p1++;
                    p2++;
                } else {
                    p2++;
                }
            } else {
                p1++;
                p2++;
            }
        }
    }

    public void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}