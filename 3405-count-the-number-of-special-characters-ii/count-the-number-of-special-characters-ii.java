class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lowerCase = new int[26];
        int[] upperCase = new int[26];
        boolean[] result = new boolean[26];
        boolean[] visited = new boolean[26];

        // get lower case first
        for(char c: word.toCharArray()) {
            if(Character.isLowerCase(c)) {
                lowerCase[c-'a']++;
            }
        }

        int[] currentLowerCase = new int[26];
        for(char c: word.toCharArray()) {
            if(Character.isLowerCase(c)) {
                currentLowerCase[c-'a']++;
            } else {
                char l = Character.toLowerCase(c);
                if(!visited[c-'A'] && !result[l-'a']) {
                    if(lowerCase[l-'a'] != 0 && currentLowerCase[l-'a'] == lowerCase[l-'a']) {
                        result[l-'a'] = true;
                    }
                    visited[c - 'A'] = true;
                }
                upperCase[c-'A']++;
            }
        }
        int count = 0;
        for(int i = 0; i < 26; i++) {
            if(result[i]) {
                count += 1;
            }
        }

        return count;
    }
}