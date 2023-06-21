class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        Set<Character> res = new HashSet<>();
        for(char c: s.toCharArray()) {
            res.add(c);
        }
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(res.contains(Character.toUpperCase(ch)) && res.contains(Character.toLowerCase(ch))) {
                continue;
            }
            String s1 = longestNiceSubstring(s.substring(0,i));
            String s2 = longestNiceSubstring(s.substring(i+1));
            return s1.length() >= s2.length() ? s1 : s2;
        }
        return s;
    }
}