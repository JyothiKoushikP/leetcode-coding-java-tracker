class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long z1 = 0, z2 = 0;
        long sum1 = 0, sum2 = 0;
        for(int x: nums1) {
            if(x == 0) z1++;
            sum1 += x;
        }
        for(int x: nums2) {
            if(x == 0) z2++;
            sum2 += x;
        }

        if(z1 == 0 && z2 != 0) {
            if(sum1 <= sum2) return -1;
        } else if(z2 == 0 && z1 != 0) {
            if(sum2 <= sum1) return -1;
        } else if (z2 == 0 && z1 == 0) {
            if(sum1 == sum2) return sum1;
            return -1;
        }
        
        if(sum1 == sum2) {
            if(z1 == 0 || z2 == 0) return -1;
            if(z1 == z2) return sum1 + z1;
            return sum1 + Math.max(z1,z2);
        }else if(sum1 > sum2) {
            if(z1 >= z2) {
                return sum1 + z1;
            } else {
                long diff = sum1 + z1 - sum2;
                if(diff < z2) {
                    return z1 == 0 ? -1 : sum2 + z2;
                }
                return sum1 + z1;
            }
        } else {
            if(z2 >= z1) {
                return sum2 + z2;
            } else {
                long diff = sum2 + z2 - sum1;
                if(diff < z1) {
                    return z2 == 0 ? -1 : sum1 + z1;
                }
                return sum2 + z2;
            }
        }

    }
}