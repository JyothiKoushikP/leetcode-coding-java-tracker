class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int start = 0, max = 0, win = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'A']++;
            max = Math.max(max,freq[ch - 'A']);
            if((i - start + 1) - max > k) {
                    freq[s.charAt(start) - 'A']--;
                    start++;
            }
            win = Math.max(win, (i - start + 1));
        }
        return win;
    }
}