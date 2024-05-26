

import static java.lang.Math.sqrt;

class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long result = 0L;
        Map<Integer,Integer> res = new HashMap<>();
        for(int i: nums2) {
            res.put(i * k, res.getOrDefault(i*k, 0) + 1);
        }

        for(int i : nums1) {
            for(int j = 1 ; j <= sqrt(i); j++) {
            if(i % j == 0) {
                result += res.getOrDefault(j, 0);
                if(j != i/j) {
                    result += res.getOrDefault(i/j, 0);
                }
            }
        }
    }
        return result;
    }
}