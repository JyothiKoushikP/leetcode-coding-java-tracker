class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] remainder = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i] % k + k) % k;
            remainder[i] = sum;
        }
        int count = 0;
        Map<Integer,Integer> rem = new HashMap();
        for(int i = 0; i < remainder.length; i++) {
            int r = remainder[i];
            if(r == 0) {
                count++;
            }
            count += (rem.getOrDefault(r,0));
            rem.put(r,rem.getOrDefault(r,0) + 1);
        }
        return count;
    }
}