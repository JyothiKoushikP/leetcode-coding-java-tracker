class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> charToString = new HashMap();
        HashMap<String,Character> stringToChar = new HashMap();
        String[] words = s.split(" ");
        if(words.length != pattern.length()) {
            return false;
        }
        for(int i = 0; i < pattern.length();i++) {
            char ch = pattern.charAt(i);
            if(charToString.containsKey(ch) && !(charToString.get(ch)).equals(words[i])) {
                return false;
            }
            if(stringToChar.containsKey(words[i]) && stringToChar.get(words[i]) != ch){
                return false;
            }
            charToString.put(ch,words[i]);
            stringToChar.put(words[i],ch);
        }
        return true;
    }
}