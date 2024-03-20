class Solution {
    public int longestArithSeqLength(int[] nums) {
        Map<Integer,Integer>[] track = new HashMap[nums.length];
        int maxLen = 0;
        for(int i = 1; i < nums.length; i++) {
            track[i] = new HashMap<>();
            for(int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                if(track[j] != null) {
                    track[i].put(diff,track[j].getOrDefault(diff,0) + 1);
                } else {
                    track[i].put(diff, 1);
                }
                maxLen = Math.max(maxLen,track[i].get(diff));
            }
        }
        return maxLen + 1;
    }
}