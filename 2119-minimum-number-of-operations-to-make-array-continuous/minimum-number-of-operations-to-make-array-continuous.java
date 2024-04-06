class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> freq = new HashMap<>();
        int me = 0, left = 0, diff = nums.length - 1;
        for(int right = 0; right < nums.length; right++) {
            freq.put(nums[right],freq.getOrDefault(nums[right],0) + 1);
            while(nums[right] - nums[left] > diff) {
                if(freq.get(nums[left]) == 1) {
                    freq.remove(nums[left]);
                } else {
                    freq.put(nums[left],freq.get(nums[left]) - 1);
                }
                left++;
            }
            me = Math.max(me,freq.size());
        }
        return nums.length - me;
    }
}