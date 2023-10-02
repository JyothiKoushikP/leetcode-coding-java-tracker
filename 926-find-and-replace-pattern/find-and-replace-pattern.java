class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList();
        for(String word: words){
            if(isMatching(word,pattern)){
                result.add(word);
            }
        }
        return result;
    }

    public boolean isMatching(String word, String pattern) {
        char[] wordToPattern = new char[256];
        char[] patternToWord = new char[256];
        if(word.length() != pattern.length()) {
            return false;
        }
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            char c = pattern.charAt(i);
            if(wordToPattern[ch-'a'] != 0 && wordToPattern[ch-'a'] != c) {
                return false;
            }
            if(patternToWord[c-'a'] != 0 && patternToWord[c-'a'] != ch) {
                return false;
            }
            wordToPattern[ch-'a'] = c;
            patternToWord[c-'a'] = ch;
        }

        return true;
    }
}