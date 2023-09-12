class Solution {
    public int reverse(int x) {
        long rev = 0L;
        boolean isNegative = false;
        if(x < 0){
            x *= -1;
            isNegative = true;
        }
        while(x > 0) {
            int rem = x % 10;
            rev = (rev * 10) + rem;
            if(rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }
        if(isNegative) {
            rev *= -1;
        }
        return (int)(rev);
    }
}