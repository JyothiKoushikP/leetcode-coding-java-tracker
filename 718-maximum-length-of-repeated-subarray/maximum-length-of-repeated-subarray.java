class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int maxLength = 0;
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums2[j] == nums1[i]) {
                    int start = j;
                    int k = i;
                    while(start < nums2.length && k < nums1.length && nums2[start] == nums1[k]){
                        start++;
                        k++;
                    }
                    maxLength = Math.max(maxLength,k - i);
                }
            }
        }
        return maxLength;
    }
}