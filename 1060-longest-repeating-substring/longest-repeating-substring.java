class Solution {
    public int longestRepeatingSubstring(String s) {
        int i = s.length();
        while(i > 0) {
            if(slidingWindow(s, i)) {
                return i;
            }
            i--;
        }
        return 0;
    }

    public boolean slidingWindow(String s, int windowSize) {
        Map<String,Integer> freq = new HashMap<>();
        int left = 0;
        StringBuilder sb = new StringBuilder();
        for(int right = 0; right < s.length(); right++) {
            sb.append(s.charAt(right));
            if(right - left + 1 == windowSize) {
                freq.put(sb.toString(), freq.getOrDefault(sb.toString(), 0) + 1);
                if(freq.get(sb.toString()) > 1) {
                    return true;
                }
                sb.deleteCharAt(0);
                left++;
            }
        }
        return false;
    }

}