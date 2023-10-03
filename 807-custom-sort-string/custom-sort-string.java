class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(char ch: order.toCharArray()) {
            int x = freq[ch - 'a'];
            for(int i = 0; i < x; i++) {
                sb.append(ch);
            }
            freq[ch - 'a'] = 0;
        }

        for(int i = 0; i < freq.length; i++) {
            if(freq[i] != 0) {
                char ch = (char)(i + 'a');
                for(int j = 0;j < freq[i]; j++) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}