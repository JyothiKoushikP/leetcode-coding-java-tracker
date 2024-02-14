class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int pos = (intLength - 1) / 2;
        int totalPossiblePalindromes = (int)Math.pow(10,pos) * 9;
        long[] res = new long[queries.length];
        for(int i = 0; i < queries.length; i++) {
            if(queries[i] > totalPossiblePalindromes) {
                res[i] = -1;
            } else {
                res[i] = calculateString(intLength,queries[i]);
            }
        }
        return res;
    }



    public long calculateString(int intLength, int query) {
        int[] res = new int[intLength];
        Arrays.fill(res,9);
        int pos = (intLength - 1) / 2;
        int divisor = (int)Math.pow(10,pos);
        int start = 0;
        while(divisor > 0 && query != 0) {
            int q = query / divisor;
            if(divisor ==  (int)Math.pow(10,pos)) {
                if(query % divisor == 0) {
                    res[start] = query/divisor;
                    res[(intLength - 1) - start] = query/divisor;
                } else {
                    res[start] = (query/divisor) + 1;
                    res[(intLength - 1) - start] = (query/divisor) + 1;

                }
            } else {
                if(query % divisor == 0) {
                    res[start] = (query/divisor) - 1;
                    res[(intLength - 1) - start] = (query/divisor) - 1;
                } else {
                    res[start] = (query/divisor);
                    res[(intLength - 1) - start] = (query/divisor);
                }
            }
            query %= divisor;
            divisor /= 10;
            start++;
        }

        long result = 0L;
        for(int i: res) {
            result = (result * 10) + i;
        }
        return result;
    }


}