class Solution {
    public void reverseString(char[] s) {
        int mid = (s.length - 1) / 2;
        for(int i = 0; i <= mid; i++) {
            char c = s[i];
            s[i] = s[(s.length - 1) - i];
            s[(s.length - 1) - i] = c;
        }
    }
    
}