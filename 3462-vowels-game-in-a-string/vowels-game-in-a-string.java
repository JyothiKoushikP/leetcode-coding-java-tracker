class Solution {
    public boolean doesAliceWin(String s) {
        int vowels = 0;
        for(char c: s.toCharArray()) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels += 1;
            }
        }
        if(vowels == 0) {
            return false;
        }
        return true;
    }
}