class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        if(x < 2){
            return x;
        }
        int left = 2, right = x/2, mid;
        long pro;
        while(left <= right){
            mid = left + (right-left)/2;
            pro = (long)mid * mid;
            if(pro > x){
                right = mid - 1;
            } else if (pro < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}