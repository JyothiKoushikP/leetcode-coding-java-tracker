class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] result = new int[n];
        int pointer = 0;
        for(int i=0;i<n;i++) {
            int index = getElement(nums1[i],nums2);
            result[pointer++] = getFirstGreaterElement(index,nums2,nums1[i]);
        }
        return result;
    }

    public int getElement(int ele, int[] nums2){
        for(int i=0;i<nums2.length;i++){
            if(nums2[i] == ele){
                return i;
            }
        }
        return 0;
    }

    public int getFirstGreaterElement(int index,int[] nums2,int searchElement) {
        for(int i=index;i<nums2.length;i++){
            if(nums2[i] > searchElement){
                return nums2[i];
            }
        }
        return -1;
    }
}