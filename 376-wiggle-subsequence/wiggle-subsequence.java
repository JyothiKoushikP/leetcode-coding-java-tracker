/*
TC: O(n^2)
SC: O(n)
Approach: 
Maintain 2 arrays positive and negative
p and n, intialize p[0] and n[0]
start from 1st index and keep the track of the max postive and negative
p[i] = Math.max(p[i],n[j] + 1);
n[i] = Math.max(n[i],p[j] + 1);
*/


class Solution {
    public int wiggleMaxLength(int[] nums) {
       int[] p = new int[nums.length];
       int[] n = new int[nums.length];
       int maxlen = 0;
       p[0] = 0; n[0] = 0;
       if(nums.length > 1) {
            if(nums[1] - nums[0] > 0) {
                p[1]++;
            } else if(nums[1] - nums[0] < 0) {
                n[1]++;
            }
       }
       for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] - nums[j] > 0) {
                    p[i] = Math.max(p[i],n[j] + 1);
                } else if(nums[i] - nums[j] < 0) {
                    n[i] = Math.max(n[i],p[j] + 1);
                }
            }
       }

       return Math.max(p[p.length-1],n[n.length-1]) + 1;
    }
}