class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int m = s2.length(), n = s1.length();
        int[] freq = new int[26];
        int[] track = new int[26];

        for(int i = 0;i < n; i++) {
            char ch = s1.charAt(i);
            freq[ch-'a']++;
        }

        int left = 0, right = 0;
        while(right < m) {
            char c = s2.charAt(right);
            track[c-'a']++;
            if(freq[c-'a'] == 0) {
                while(left <= right) {
                    track[s2.charAt(left) - 'a']--;;
                    left++;
                }
            } else if(track[c-'a'] > freq[c-'a']){
                while(left <= right && track[c - 'a'] > freq[c - 'a']) {
                    track[s2.charAt(left) - 'a']--;
                    left++;
                }
            }
            if((right-left+1) == n) {
                return true;
            }
            right++;
        }

        return false;
    }
}