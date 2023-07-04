class Solution {
    public String removeStars(String s) {
        StringBuilder res = new StringBuilder();
        int starsCount = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '*') {
                while(i < s.length() && s.charAt(i) == '*'){
                    i++;
                    starsCount++;
                }
                while(starsCount > 0){
                    int len = res.length();
                    if (len > 0) {
                     res.deleteCharAt(len - 1);
                    }
                    starsCount--;
                }
                i -= 1;
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}