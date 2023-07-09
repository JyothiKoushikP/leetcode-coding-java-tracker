class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> res = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(res.containsKey(nums[i])){
                return true;
            } else {
                res.put(nums[i],res.getOrDefault(nums[i],0)+1);
            }
        }
        return false;
    }
}