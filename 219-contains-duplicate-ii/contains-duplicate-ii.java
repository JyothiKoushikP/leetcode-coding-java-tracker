class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> ele = new HashMap();
        for(int i = 0;i < nums.length; i++) {
            if(!ele.containsKey(nums[i])) {
                ele.put(nums[i],i);
            } else {
                int index = ele.get(nums[i]);
                if(Math.abs(index - i) <= k) {
                    return true;
                } else {
                    ele.put(nums[i],i);
                }
            }
        }
        return false;
    }
}