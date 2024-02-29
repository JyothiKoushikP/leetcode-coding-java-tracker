class Solution {
    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        for(int i = 2; i <= Math.sqrt(n) ; i++) {
            if(isPrime[i]) {
                int prime = i, k = 2;
                while((prime * k) < n) {
                    isPrime[prime * k] = false;
                    k++;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < isPrime.length; i++) {
            count += isPrime[i] ? 1 : 0;
        }
        return count;
    }
}