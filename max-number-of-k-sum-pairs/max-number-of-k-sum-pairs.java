class Solution {
    public int maxOperations(int[] nums, int k) {
        int m = nums.length, start = 0, end = m-1;
        Arrays.sort(nums);

        int count = 0;
        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum == k){
                count++;
                start++;
                end--;
            } else if(sum < k) {
                start++;
            } else {
                end--;
            }
        }

        return count;
    }
}