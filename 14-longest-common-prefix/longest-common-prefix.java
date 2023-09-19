class Solution {
    public String longestCommonPrefix(String[] strs) {     
        if(strs.length == 1) {
            return strs[0];
        } 

        StringBuilder res = new StringBuilder();
        if(strs[0].length() >= strs[1].length()) {
            res = commonPrefix(strs[1],strs[0]);
        } else {
            res = commonPrefix(strs[0],strs[1]);
        }

        if(res.length() == 0) {
            return "";
        }

        for(int i = 1; i < strs.length - 1; i++) {
            StringBuilder prefix = new StringBuilder();
            if(strs[i].length() >= strs[i+1].length()) {
                prefix = commonPrefix(strs[i+1],strs[i]);
            } else {
                prefix = commonPrefix(strs[i],strs[i+1]);
            }
            System.out.println(prefix);
            if(prefix.length() == 0) {
                return "";
            }
            if(res.length() >= prefix.length()) {
                res = prefix;
            }
        }
        return res.toString();
    }

    public StringBuilder commonPrefix(String s1, String s2) {
        int i = 0;
        StringBuilder s = new StringBuilder();
        while(i < s1.length() && (s1.charAt(i) == s2.charAt(i))){
            s.append(s1.charAt(i));
            i++;
        }
        return s;
    }

}