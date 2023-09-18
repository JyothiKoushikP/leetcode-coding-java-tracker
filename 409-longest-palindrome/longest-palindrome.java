class Solution {
    public int longestPalindrome(String s) {
        int even = 0, odd = 0;
        int[] freq = new int[256];
        for(char c: s.toCharArray()) {
            freq[c]++;
        }
        for(int i: freq) {
            if(i%2 == 0){
                if(i >= 2) {
                    even += i;
                }
            } else {
                if(i > 2) {
                    even += (i-1);
                }
                odd = 1;
            }
        }
        return even + odd;
    }
}