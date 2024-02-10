class Solution {
    public String longestPalindrome(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            StringBuilder subString1 = new StringBuilder();
            StringBuilder subString2 = new StringBuilder();

            // check for odd palindrome
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
                left--;
                right++;
            }

            for(int k = left + 1; k < right; k++) {
                subString1.append(s.charAt(k));
            }


            //check for even palindrome
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                left = i - 1;
                right = i + 2;
                while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
                    left--;
                    right++;
                }
                for(int k = left + 1; k < right; k++) {
                    subString2.append(s.charAt(k));
                }
            } else {
                subString2.append(c);
            }

            if (res.length() < subString1.length()) {
                res = subString1;
            }
            if (res.length() < subString2.length()) {
                res = subString2;
            }
        }
        return res.toString();
    }
}