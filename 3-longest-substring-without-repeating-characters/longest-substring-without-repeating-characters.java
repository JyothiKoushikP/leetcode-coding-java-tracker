class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0,start = 0;
        char[] freq = new char[256];
        int left = 0, maxLen = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq[c]++;
            if(freq[c] > 1) {
                while(freq[c] > 1) {
                    freq[s.charAt(left)]--;
                    left++;
                }
                maxLen = Math.max(right - left + 1, maxLen);
            } else {
                maxLen = Math.max(right - left + 1, maxLen);
            }
        }
        return maxLen;
    }
}