class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int len = nums.length;
        for(int low = 0; low <= nums.length - 3; low++) {
            if(low == 0 || (low > 0 && nums[low] != nums[low-1])) {
                int mid = low + 1, high = len - 1;
                while(mid < high) {
                    int sum = nums[low] + nums[mid] + nums[high];
                    if(sum > target) {
                        if(closest == Integer.MIN_VALUE){
                            closest = sum;
                        } else if(Math.abs(target - closest) > Math.abs(target - sum)) {
                            closest = sum;
                        }
                        high--;
                    } else if(sum < target) {
                        if(closest == Integer.MIN_VALUE){
                            closest = sum;
                        } else if(Math.abs(target - closest) > Math.abs(target - sum)) {
                            closest = sum;
                        }
                        mid++;
                    } else {
                        closest = target;
                        break;
                    }
                }
            }
        }
        return closest;
    }
}