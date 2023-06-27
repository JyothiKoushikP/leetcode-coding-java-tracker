class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int startPointer = 0;
        int startElement = nums[0];
        int count = 0;
        int updatedIndex = n;
        int i = 0;
        if(n == 1){
            return 1;
        }
        while(i < updatedIndex) {
            while(i < updatedIndex && nums[i] == startElement && count < 2){
                i++;
                count++;
            }

            if(i < updatedIndex && nums[i] == startElement){
                int j=i;
                while(j < updatedIndex && nums[j] == startElement) {
                    j++;
                }
                updatedIndex += (i-j);
                swap(nums,i,j);
            }
            if(i < updatedIndex) {
                startPointer = i;
                startElement = nums[startPointer];
                count = 0;
            }
        }
        return i;
    }

    void swap(int[] nums, int duplicatePointer,int actualPointer){
        int n = nums.length;
        while(actualPointer < n){
            int temp = nums[duplicatePointer];
            nums[duplicatePointer] = nums[actualPointer];
            nums[actualPointer] = temp;
            duplicatePointer++;
            actualPointer++;
        }
    }


}