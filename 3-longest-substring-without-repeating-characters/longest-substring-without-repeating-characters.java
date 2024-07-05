/* Dynamic Sliding Window */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> track = new HashMap<>();
        int maxLen = 0, left = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            track.put(c,track.getOrDefault(c, 0) + 1);
            while((right - left + 1) != track.size()) {
                char l = s.charAt(left);
                if(track.get(l) == 1) {
                    track.remove(l);
                } else {
                    track.put(l,track.get(l) - 1);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left + 1);
        }
        return maxLen;
    }
}