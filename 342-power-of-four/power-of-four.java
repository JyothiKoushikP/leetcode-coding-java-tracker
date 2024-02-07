class Solution {
    public boolean isPowerOfFour(int n) {
        long x = (long)n;
        return ((x & (x-1)) == 0) && ((x-1) % 3 == 0);

    }
}