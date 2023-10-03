class Solution {
    public int[] searchRange(int[] nums, int target) {
        boolean isFirstIndex = true;
        int n = nums.length;
        int firstOccurence = binarySearch(nums,target,true,0,n-1);
        if(firstOccurence == -1) {
            return new int[] {-1, -1};
        }
        int secondOccurence = binarySearch(nums,target,false,0,n-1);
        return new int[] {firstOccurence, secondOccurence};
    }

    public int binarySearch(int[] arr, int target, boolean isFirstIndex,int start,int end) {
        int n = arr.length;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(arr[mid] == target) {
                if(isFirstIndex) {
                    if(mid > 0) {
                        if(arr[mid - 1] == target) {
                            end = mid - 1;
                        } else {
                            return mid;
                        }
                    } else {
                        return mid;
                    }
                } else {
                    if(mid < n-1 ){
                        if(arr[mid + 1] == target) {
                            start = mid + 1;
                        } else {
                            return mid;
                        }
                    } else {
                        return mid;
                    }
                } 
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}