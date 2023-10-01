class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int start = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(freq[c] > 0) {
                while(freq[c] != 0) {
                    char ch = s.charAt(start);
                    freq[ch]--;
                    start++;
                }
            }
            freq[c]++;
            max = Math.max((i-start)+1,max);
        }
        return max;
    }
}