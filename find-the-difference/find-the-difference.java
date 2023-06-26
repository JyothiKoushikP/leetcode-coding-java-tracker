class Solution {
    public char findTheDifference(String s, String t) {
        int result = 0;
        for(char c: s.toCharArray()) {
            result ^= (c - 'a' + 1);
        }
        for(char c1: t.toCharArray()) {
            result ^= (c1 - 'a' + 1);
        }

        return (char)(result + 'a' - 1);
    }
}