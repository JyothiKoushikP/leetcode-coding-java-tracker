class Solution {
    public int minOperations(int[] nums, int x) {
        int left = 0, right = nums.length, minOperations = Integer.MAX_VALUE;
        int sum = 0;
        while(left < nums.length && sum < x) {
            sum += nums[left++];
        }
        if(left == nums.length) {
            return (sum == x) ? nums.length : -1;
        }
        left--;
        if(sum == x) {
            minOperations = Math.min(minOperations,left + 1);
        }
        while(left != -1 && sum >= x) {
            sum -= nums[left--];
        }
        while(left < right) {
            if(sum >= x) {
                if(sum == x) {
                    minOperations = Math.min(minOperations,((left + 1) + (nums.length - right)));
                }
                if(left == -1) {
                    break;
                }
                sum -= nums[left];
                left--;
            } else {
                right--;
                sum += nums[right];
            }
        }

        return minOperations == Integer.MAX_VALUE ? -1 : minOperations;
    }
}