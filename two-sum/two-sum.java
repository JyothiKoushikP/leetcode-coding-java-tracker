class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> res = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(!res.containsKey(nums[i])){
                res.put(nums[i],i);
            }
            int complement = target - nums[i];
            if(res.containsKey(complement) && (res.get(complement) != i)){
                return new int[]{res.get(complement),i};
            }
        }
        return new int[]{};
    }
}