class Solution {
    public boolean isArmstrong(int n) {
        int digits = (int)(Math.log10(n)) + 1;
        int org = n, sum = 0;
        while(n > 0){
            int rem = n % 10;
            sum += Math.pow(rem,digits);
            n /= 10;
        }

        return sum == org;
    }
}