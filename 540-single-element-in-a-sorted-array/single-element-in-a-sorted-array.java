class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        int start = 0, end = n - 1;
        if(n == 1) {
            return arr[0];
        }
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(mid == 0 || mid == n-1) {
                return arr[mid];
            }else if(mid > 0 && mid < n-1 && (arr[mid-1] != arr[mid]) && (arr[mid] != arr[mid+1])) {
                return arr[mid];
            } else if(mid > 0 && (arr[mid-1] == arr[mid])) {
                if(mid % 2 == 0) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if(mid < n-1 && (arr[mid+1] == arr[mid])){
                if(mid % 2 != 0) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return arr[start];
    }
}