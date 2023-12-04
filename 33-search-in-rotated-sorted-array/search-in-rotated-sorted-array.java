class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(nums[0] <= nums[n-1]) {
            return binarySearch(nums,target,0,n-1);
        }
        int pivot = findPivot(nums);
        int res1 = binarySearch(nums,target,0,pivot-1);
        if(res1 != -1) {
            return res1;
        }
        int res2 = binarySearch(nums,target,pivot,n-1);
        
        return res2;
    }

    public int findPivot(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] >= nums[0]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

   
}