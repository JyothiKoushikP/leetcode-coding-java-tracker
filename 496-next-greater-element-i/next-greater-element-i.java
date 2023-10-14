class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, pointer = 0;
        int[] result = new int[m];
        for(int i: nums1) {
            result[pointer++] = findGreaterElement(nums2,i);
        }
        return result;
    }

    public int findGreaterElement(int[] nums, int target) {
        int n = nums.length;
        boolean didFind = false;
        for(int i = 0; i < n; i++) {
            if(didFind) {
                if(nums[i] > target) {
                    return nums[i];
                }
            }
            if(nums[i] == target) {
                didFind = true;
            }
        }
        return -1;
    }
}