class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character,Integer> res = new HashMap<>();
        int max = Integer.MIN_VALUE, sum=0,start=0;
        if(s.length() * k == 0){
            return 0;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!res.containsKey(ch)){
                res.put(ch,res.getOrDefault(ch,0)+1);
            } else {
                res.put(ch,res.get(ch)+1);
            }
            sum += 1;
            if(res.size() <= k){
                max = max > sum ? max : sum;
            } else {
                while(res.size() > k){
                    char cd = s.charAt(start);
                    if(res.get(cd) == 1){
                        res.remove(cd);
                    } else {
                        res.put(cd,res.get(cd)-1);
                    }
                    sum -= 1;
                    start++;
                }
            }
        }
        return max;
    }
}