class Solution {
    public int majorityElement(int[] nums) {
        int result = 0;
        HashMap<Integer,Integer> res = new HashMap<>();
        for(int i: nums){
            if(!res.containsKey(i)){
                res.put(i,1);
            } else {
                res.put(i,res.getOrDefault(i,0)+1);
            }
        }

        for(int i: res.keySet()) {
            int value = res.get(i);
            if(value > (nums.length/2)) {
                result = i;
            }
        }

        return result;
    }
}