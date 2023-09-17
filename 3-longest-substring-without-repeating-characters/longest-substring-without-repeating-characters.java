class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charCount = new int[128];
        int start = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount[c]++;
            
            if(charCount[c] > 1) {
                while(charCount[c] > 1){
                    charCount[s.charAt(start)]--;
                    start++;
                }
            }
            max = Math.max(max,(i-start)+1);
        }
        return max;
    }
}