class Solution {
    public int xorOperation(int n, int start) {
        int result = start;
        int i = 0;
        while (i < n-1) {
            start += 2;
            result ^= start;
            i++;
        }
        return result;
    }
}