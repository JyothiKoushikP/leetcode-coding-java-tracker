class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap();
        int prefixSum = 0, count = 0, n = nums.length;
        freq.put(0, 1);
        for(int i = 0; i < n; i++) {
            prefixSum += nums[i];
             if(freq.containsKey(prefixSum - k)) {
                count += freq.get(prefixSum - k);
            }
            freq.put(prefixSum,freq.getOrDefault(prefixSum,0) + 1);
        }

        return count;
    }
}