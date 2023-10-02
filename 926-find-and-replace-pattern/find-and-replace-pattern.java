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
        HashMap<Character,Character> map = new HashMap();
        HashMap<Character,Character> map2 = new HashMap();
        if(word.length() != pattern.length()) {
            return false;
        }
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            char c = pattern.charAt(i);

            if(map.containsKey(c) && map.get(c) != ch) {
                return false;
            }
            if(map2.containsKey(ch) && map2.get(ch) != c) {
                return false;
            }
            map.put(c,ch);
            map2.put(ch,c);
        }

        return true;
    }
}