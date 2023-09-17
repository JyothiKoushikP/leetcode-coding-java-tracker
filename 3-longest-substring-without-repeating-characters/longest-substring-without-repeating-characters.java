class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> sub = new HashMap();
        int start = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sub.put(c,sub.getOrDefault(c,0)+1);
            if(sub.get(c) > 1) {
                while(sub.get(c) > 1){
                    char p = s.charAt(start);
                    sub.put(p,sub.get(p)-1);
                    start++;
                }
            }
            max = Math.max(max,(i-start)+1);
        }
        return max;
    }
}