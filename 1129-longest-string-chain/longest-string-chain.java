class Solution {
    public int longestStrChain(String[] words) {
        int[] dp = new int[words.length];
        Arrays.sort(words,new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int len = a.length() - b.length();
                if(len == 0) {
                    return a.compareTo(b);
                }
                return len;
            }
        });
        dp[0] = 1;
        int result = 1;
        for(int i = 1; i < words.length; i++) {
            int maxCount = 1;
            for(int j = 0; j < i; j++) {
                if(isSubSequence(words[j],words[i])) {
                    maxCount = Math.max(maxCount,dp[j] + 1);
                }
            }
            dp[i] = maxCount;
            result = Math.max(result,dp[i]);
        }
        return result;
    }

    public boolean isSubSequence(String s,String t) {
        if(t.length() - s.length() > 1) return false;
        if(s.equals(t)) return false;
        int sPointer = 0, tPointer = 0, m = s.length(),n = t.length();
        while(sPointer < m && tPointer < n){
            if(s.charAt(sPointer) == t.charAt(tPointer)){
                sPointer++;
                tPointer++;
            } else {
                tPointer++;
                }
            }
        return (sPointer == m) ? true : false;
    }
}