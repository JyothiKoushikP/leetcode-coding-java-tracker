class Solution {
    public long distributeCandies(int n, int limit) {
        long sum = 0L;
        for(int i = limit; i >= 0; i--) {
            int rem = n - i;
            int minLimit, maxLimit;
            if(rem >= 0) {
                if(rem <= limit) {
                    minLimit = 0;
                    maxLimit = rem;
                } else {
                    maxLimit = limit;
                    minLimit = (rem - maxLimit);
                }
            sum += (maxLimit >= minLimit) ? (maxLimit - minLimit) + 1 : 0;
            }
        }
        return sum;
    }
}