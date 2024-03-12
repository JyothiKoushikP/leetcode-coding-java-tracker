class Solution {
    public long continuousSubarrays(int[] nums) {
        long total = 0L;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        int left = 0, right = 0;
        while (right < nums.length) {
            max.add(nums[right]);
            min.add(nums[right]);
            while (max.peek() - min.peek() > 2) {
                int i = nums[left];
                max.remove(i);
                min.remove(i);
                left++;
            }
            total += (right - left) + 1;
            right++;
        }
        return total;
    }
}