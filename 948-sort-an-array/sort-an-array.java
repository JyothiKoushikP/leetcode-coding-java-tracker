class Solution {
    public int[] sortArray(int[] nums) {
        int s = 0, e = nums.length;
        mergeSortArray(nums,s,e);
        return nums;
    }

    public void mergeSortArray(int[] nums, int start, int end) {
        if(end - start == 1){
            return;
        }
        int mid = start + (end-start)/2;
        mergeSortArray(nums,start,mid);
        mergeSortArray(nums,mid,end);

        mergeArray(nums,start,mid,end);
    }

    public void mergeArray(int[] nums, int start, int mid, int end) {
        int i = start, j = mid, k = 0;
        int[] mix = new int[end - start];

        while (i < mid && j < end) {
            if(nums[i] < nums[j]) {
                mix[k++] = nums[i++];
            } else {
                mix[k++] = nums[j++];
            }
        }

        while(i < mid) {
            mix[k++] = nums[i++];
        }
        while(j < end) {
            mix[k++] = nums[j++];
        }

        for(int l = 0; l < mix.length; l++) {
            nums[start + l] = mix[l];
        }

    }
}