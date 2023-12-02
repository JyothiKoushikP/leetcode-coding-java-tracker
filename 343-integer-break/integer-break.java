class Solution {
    public int integerBreak(int n) {
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++) {
            int product = 0;
            int div = n/i;
            int rem = n%i;
            if(div != 1 && rem == 1) {
                product = (int)(Math.pow(i,div-1)) * (i + rem);
            } else {
                product = (int)(Math.pow(i,div)) * (rem == 0 ? 1 : rem);
            }
            max = Math.max(max,product);
        }
        return max;
    }
}