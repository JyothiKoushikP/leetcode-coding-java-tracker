class Solution {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if((i == 0) || (i > 0 && nums[i] != nums[i-1])) {
                threeSum(i,target,nums);
            }
        }
        return result;
    }

    public void threeSum(int start, int target, int[] nums) {
        int len = nums.length;
        long req = target - nums[start];
        for(int low = start + 1; low <= nums.length - 3; low++) {
            if(low == start + 1 || (low > start + 1 && nums[low] != nums[low-1])) {
                int mid = low + 1, high = len - 1;
                while(mid < high) {
                    long l = nums[low], m = nums[mid], h = nums[high];
                    long sum = l + m + h;
                    if(sum > req) {
                        high--;
                    } else if(sum < req) {
                        mid++;
                    } else {
                        List<Integer> entry = new ArrayList();
                        entry.add(nums[start]);
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
    }
}