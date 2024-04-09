

import com.sun.net.httpserver.Authenticator.Result;

class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1000000007;
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for(int i = 1; i < pow.length; i++) {
            pow[i] = (2 * pow[i-1]) % mod;
        }
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int index = binarySearch(nums,target,i);
            if(index >= i) {
                int l = index - i;
                result = (result + pow[l]) % mod;
            }
        }
        return result;
    }

    public int binarySearch(int[] nums, int target, int start) {
        int s = start, e = nums.length - 1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(nums[start] + nums[mid] <= target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return e;
    }
}