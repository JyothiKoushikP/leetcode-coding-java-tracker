class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> res = new HashMap();
        int maximum = Integer.MIN_VALUE;

        for(int i: nums) {
            maximum = Math.max(maximum,i);
            res.put(i,res.getOrDefault(i,0) + 1);
        }

        int count = 0;
        while(count <= n) {
            if(res.containsKey(maximum)) {
                count += res.get(maximum);
            }
            if(count >= k){
                return maximum;
            }
            maximum--;
        }

        return 0;
    }
}