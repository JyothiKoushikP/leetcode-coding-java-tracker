class Solution {
    public int trailingZeroes(int n) {
        if(n == 0) {
            return 0;
        }
        int twoCount = 0, fiveCount = 0;
        for(int i = 1; i <= n; i++) {
            if(i % 2 == 0){
                twoCount += getFactorCount(i,2);
            }
            if(i % 5 == 0){
                fiveCount += getFactorCount(i,5);
            }
        }

        if(twoCount == 0 || fiveCount == 0) {
            return 0;
        }
        return Math.min(twoCount,fiveCount);
    }

    public int getFactorCount(int n, int x) {
        int count = 0;
        while(n % x == 0) {
            count++;
            n /= x;
        }
        return count;
    }
}