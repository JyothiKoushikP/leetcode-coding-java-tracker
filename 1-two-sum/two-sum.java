class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> track = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(track.containsKey(complement) && track.get(complement) != i) {
                return new int[] {track.get(complement),i};
            }
            track.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}