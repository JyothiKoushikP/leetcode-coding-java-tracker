class Solution {
    int index = 0;
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            char ch = s.charAt(index);
            if(!Character.isDigit(ch)) {
                res.append(ch);
                index++;
            } else {
                int k = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    k = k * 10 + (s.charAt(index) - '0');
                    index++;
                }
                index++;
                String decodeString = decodeString(s);
                index++;
                while (k > 0) {
                    res.append(decodeString);
                    k--;
                }
            }
        }
        return res.toString();
    }
}