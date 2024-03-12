class Solution {

    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;
        while(k > 0 && nums[k] == 2) {
            k--;
        }
        while(j <= k) {
            if(nums[j] == 2) {
                swap(nums,j,k);
                k--;
            } else if(nums[j] == 0) {
                swap(nums,j,i);
                i++;
                j++;
            } else {
                j++;
            }
        }
    }

    public void swap(int[] nums,int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

}