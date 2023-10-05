class Solution {
    public int trailingZeroes(int n) {
        int powerOf5 = 5;
        int res = 0;
        while(n >= powerOf5) {
            res += (n/powerOf5);
            powerOf5 *= 5;
        }

        return res;
    }
}