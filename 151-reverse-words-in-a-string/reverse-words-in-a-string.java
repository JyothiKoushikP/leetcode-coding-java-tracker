class Solution {
    public String reverseWords(String s) {
       int n = s.length();
       int i = n-1;
       StringBuilder word = new StringBuilder();
       StringBuilder sentence = new StringBuilder();
       while (i >= 0) {
           char c = s.charAt(i);
           if(c == ' ') {
                if(word.length() != 0) {
                    sentence.append(word);
                    sentence.append(' ');
                    word.setLength(0);
                }
           } else {
               word.insert(0,c);
           }
           i--;
       }
       sentence.append(word);
       return (sentence.toString()).trim();
    }
}