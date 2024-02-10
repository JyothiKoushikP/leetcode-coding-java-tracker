class Solution {
    public String longestPalindrome(String s) {
        StringBuilder res = new StringBuilder();
        int maxLeft = 0, maxRight = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);


            // check for odd palindrome
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
                left--;
                right++;
            }

            if(right - left - 1 > maxLength) {
                maxLeft = left + 1;
                maxRight = right - 1;
                maxLength = right - left - 1;
            }


            //check for even palindrome
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                left = i - 1;
                right = i + 2;
                while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
                    left--;
                    right++;
                }
                if(right - left - 1 > maxLength) {
                    maxLeft = left + 1;
                    maxRight = right - 1;
                    maxLength = right - left - 1;
                }
            }
        }
        for(int i = maxLeft; i <= maxRight; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}