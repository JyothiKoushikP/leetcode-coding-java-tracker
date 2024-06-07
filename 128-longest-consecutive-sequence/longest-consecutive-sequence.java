class Solution {
    public int longestConsecutive(int[] arr) {
       Set<Integer> a = new HashSet<>();
       for(int i: arr) {
            a.add(i);
       } 
       int maxLen = 0;
       for(int i: arr) {
            int currLen = 1;
            if(!a.contains(i-1)) {
                int x = i+1;
                while(a.contains(x)) {
                    currLen++;
                    x++;
                }
            }
            maxLen = Math.max(maxLen,currLen);
       }
       return maxLen;
    }
}