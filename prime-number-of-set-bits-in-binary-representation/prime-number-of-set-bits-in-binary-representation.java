class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i = left; i <= right; i++) {
            if(isPrime(getBits(i))) count++;
        }
        return count;
    }

    public int getBits(int n) {
        int c = 0;
        while(n > 0){
            c += n & 1;
            n >>= 1;
        }
        return c;
    }

    public boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}