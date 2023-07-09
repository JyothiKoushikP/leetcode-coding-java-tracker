class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        HashMap<Integer,Integer> result = new HashMap();
        
        for(int i = 0; i < n; i++) {
            result.put(nums[i] - i,result.getOrDefault(nums[i] - i,0) + 1);
        }

        long totalPairs = (n * (n - 1L)) / 2L;

        for(int key: result.keySet()) {
            int m = result.get(key);
            if(m > 1) {
                totalPairs -= (m * (m-1L)) / 2L;
            }
        }
        return totalPairs;
    }
}