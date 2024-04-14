class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        int len = nums.length;
        for(int low = 0; low <= nums.length - 3; low++) {
            if(low == 0 || (low > 0 && nums[low] != nums[low-1])) {
                int mid = low + 1, high = len - 1;
                while(mid < high) {
                    if(nums[low] + nums[mid] + nums[high] > 0) {
                        high--;
                    } else if(nums[low] + nums[mid] + nums[high] < 0) {
                        mid++;
                    } else {
                        List<Integer> entry = new ArrayList();
                        entry.add(nums[low]);
                        entry.add(nums[mid]);
                        entry.add(nums[high]);
                        result.add(entry);
                        mid++;
                        while(mid < high && nums[mid] == nums[mid-1]) {
                            mid++;
                        }
                    }
                }
            }
        }
        return result;
    }
}