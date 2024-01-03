class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 2 && nums[i] <= 0; i++) {
            int mid = i+1, high = nums.length - 1;
            if(i == 0 || nums[i-1] != nums[i]) {
                while(mid < high) {
                    if(nums[i] + nums[mid] + nums[high] < 0) {
                        mid++;
                    } else if(nums[mid] + nums[i] + nums[high] > 0) {
                        high--;
                    } else {
                        List<Integer> p = new ArrayList<>();
                        p.add(nums[i]);
                        p.add(nums[mid++]);
                        p.add(nums[high--]);
                        result.add(p);
                        while (mid < high && nums[mid] == nums[mid - 1]) {
                            mid++;
                        }
                    }
                }
            }
        }
        return result;
    }
}