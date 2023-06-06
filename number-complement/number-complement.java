class Solution {
    public int findComplement(int num) {
        int n = 0;
        int i = 0;
        while(num > 0){
            int x = 1 ^ (num & 1);
            n += (int)(Math.pow(2,i)) * x;  
            i++;
            num >>= 1;
        }
        return n;
    }
}