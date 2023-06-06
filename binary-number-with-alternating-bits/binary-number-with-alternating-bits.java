class Solution {
    public boolean hasAlternatingBits(int n) {
        int rem = n % 2;
        n = n/2;
        while(n != 0){
            int c = n % 2;
            if(c == rem){
                return false;
            }
            n /= 2;
            rem = c;
        }
        return true;
    }
}