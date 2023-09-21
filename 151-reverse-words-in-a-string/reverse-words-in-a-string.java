class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int n = s.length();
        for(int i = n-1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                if(word.length() != 0) {
                    result.append(word);
                    result.append(" ");
                    word.setLength(0);
                }
            } else {
                word.insert(0,ch);
            }
        }
        if(word.length() != 0) {
            result.append(word);
            result.append(" ");
            word.setLength(0);
        }
        return (result.toString()).trim();
    }
}