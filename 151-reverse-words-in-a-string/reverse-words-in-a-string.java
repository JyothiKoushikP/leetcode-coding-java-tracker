class Solution {
    public String reverseWords(String s) {
       StringBuilder trimmed = trimSpaces(s);
        reverseString(trimmed,0,trimmed.length()-1);
        int start = 0;
        while (start < trimmed.length()) {
            int end = start;
            while (end < trimmed.length() && trimmed.charAt(end) != ' ') {
                end++;
            }
            reverseString(trimmed,start,end-1);
            start = end + 1;
        }
        return trimmed.toString();
    }

    public StringBuilder reverseString(StringBuilder p, int left, int right) {
        while(left < right) {
            char l = p.charAt(left);
            char r = p.charAt(right);

            char c = l;
            p.setCharAt(left,r);
            p.setCharAt(right,c);

            left++;
            right--;
        }
        return p;
    }

    public StringBuilder trimSpaces(String s) {
        StringBuilder res = new StringBuilder();
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' '){
            right--;
        }

        while(left <= right) {
            char c = s.charAt(left);
            if(c != ' ') {
                res.append(c);
            } else if(left > 0 && s.charAt(left-1) != ' '){
                res.append(' ');
            }
            left++;
        }
        return res;
    }
}