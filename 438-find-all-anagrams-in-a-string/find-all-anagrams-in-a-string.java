class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        int m = s.length(), n = p.length();
        int[] freq = new int[26];
        int[] track = new int[26];

        for(int i = 0;i < n; i++) {
            char ch = p.charAt(i);
            freq[ch-'a']++;
        }

        int left = 0, right = 0;
        while(right < m) {
            char c = s.charAt(right);
            track[c-'a']++;
            if(freq[c-'a'] == 0) {
                while(left <= right) {
                    track[s.charAt(left) - 'a']--;;
                    left++;
                }
            } else if(track[c-'a'] > freq[c-'a']){
                while(left <= right && track[c - 'a'] > freq[c - 'a']) {
                    track[s.charAt(left) - 'a']--;
                    left++;
                }
            }
            if((right-left+1) == n) {
                result.add(left);
            }
            right++;
        }

        return result;
    }
}