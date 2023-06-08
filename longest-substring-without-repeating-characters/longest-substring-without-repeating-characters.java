class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0,start = 0;
        HashMap<Character,Integer> res = new HashMap<Character,Integer>();
        for(char c: s.toCharArray()){
            if(!res.containsKey(c)){
                res.put(c,1);
            } else {
                while(res.containsKey(c)){
                    res.remove(s.charAt(start));
                    start++;
                }
                res.put(c,1);
            }
            max = max > res.size() ? max : res.size();
        }
        return max;
    }
}