class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3; i++) {
            for(int j = i + 1; j <= nums.length - 2 && nums[i] != 0; j++) {
                int sum = nums[i] + nums[j];
                int index = binarySearch(nums,j+1,nums.length-1,sum);
                count += (index - j);
            }
        }
        return count;
    }

    public int binarySearch(int[] nums, int low, int high, int sum) {
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] < sum) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}