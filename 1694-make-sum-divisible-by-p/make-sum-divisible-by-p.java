class Solution {
    public int minSubarray(int[] nums, int p) {
    int minLen = Integer.MAX_VALUE;
    Map<Long,Integer> track = new HashMap<>();
    long sum = 0L;
    
    for (int num : nums) {
        sum += num;
    }
    
    if (sum % p == 0) {
        return 0;
    }
    
    long remainder = sum % p;
    
    long prefixSum = 0;
    track.put(0L, -1);
    
    for (int i = 0; i < nums.length; i++) {
        prefixSum += nums[i];
        long currRemainder = prefixSum % p;
        long targetRemainder = (currRemainder - remainder + p) % p;
        
        if (track.containsKey(targetRemainder)) {
            minLen = Math.min(minLen, i - track.get(targetRemainder));
        }
        
        track.put(currRemainder, i);
    }
    
    return minLen == Integer.MAX_VALUE || minLen == nums.length ? -1 : minLen;
}

}