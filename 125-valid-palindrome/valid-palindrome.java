class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        char[] s1 = s.toCharArray();
        while(start < end) {
            char b = s1[start];
            char e = s1[end];
            if(!Character.isAlphabetic(b) && !Character.isDigit(b)) {
                start++;
                continue;
            } else if(!Character.isAlphabetic(e) && !Character.isDigit(e)) {
                end--;
                continue;
            } 
            if(Character.isUpperCase(b)) {
                b = Character.toLowerCase(b);
            } 
            if(Character.isUpperCase(e)) {
                e = Character.toLowerCase(e);
            }

            if(b != e) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

}