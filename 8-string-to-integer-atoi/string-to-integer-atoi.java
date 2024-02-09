class Solution {
        public static int myAtoi(String s) {
        int len = s.length(), left = 0;
        while(left < len && s.charAt(left) == ' ') {
            left++;
        }
        int sign = 1;
        if(left < len && s.charAt(left) == '-') {
            sign = -1;
            left++;
        } else if(left < len && s.charAt(left) == '+') {
            sign = 1;
            left++;
        }
        int right = left;
        while(right < len &&Character.isDigit(s.charAt(right))) {
            right++;
        }
        int result = 0;
        while (left < right) {
            int digit = s.charAt(left) - '0';
            if((result > (Integer.MAX_VALUE /10)) || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = (result * 10) + digit;
            left++;
        }
        return sign * result;
    }
}