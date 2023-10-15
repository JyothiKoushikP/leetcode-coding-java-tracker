class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int ones = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '1') ones++;
            sb.append(ch);
            if(ones > k) {
                while(ones > k) {
                    char c = sb.charAt(0);
                    if(c == '1') ones--;
                    sb.deleteCharAt(0);
                }
            }
            if(ones == k) {
                while(sb.charAt(0) != '1') {
                    sb.deleteCharAt(0);
                }

                if(sb.length() < minLen) {
                    minLen = sb.length();
                    result = new StringBuilder(sb);
                } else if(sb.length() == minLen) {
                    int comparison = (sb.toString()).compareTo(result.toString());
                    if(comparison < 0) {
                        result = new StringBuilder(sb);
                    }
                }
            }
            
        }

        return result.toString();
    }
}