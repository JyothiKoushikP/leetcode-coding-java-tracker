class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> charToString = new HashMap();
        String[] words = s.split(" ");
        if(words.length != pattern.length()) {
            return false;
        }
        for(int i = 0; i < pattern.length();i++) {
            char ch = pattern.charAt(i);

            if(charToString.containsKey(ch)) {
                if(!(charToString.get(ch)).equals(words[i])){
                    return false;
                }
            } else {
                if(charToString.containsValue(words[i])){
                    return false;
                }
            }

            charToString.put(ch,words[i]);

        }
        return true;
    }
}