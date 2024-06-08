class Solution {
    public int findKthLargest(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        int maxValue = 0;
        for(int i: nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
            maxValue = Math.max(maxValue, i);
        }
        while(k > 0) {
            int x = freq.getOrDefault(maxValue,0);
            k -= x;
            if(k <= 0) {
                return maxValue;
            }
            maxValue--;
        }
        return maxValue;
    }
}