class Solution {
    public boolean judgeSquareSum(int c) {
        int s = 0;
        int max = 46340;
        for(int i = 0; i <= max; i++) {
            int curr = i * i;
            int target = c - curr;
            if(binarySearch(s,max,target) != -1) {
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start)/ 2;
            if(mid * mid == target) {
                return mid;
            } else if(mid * mid > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}