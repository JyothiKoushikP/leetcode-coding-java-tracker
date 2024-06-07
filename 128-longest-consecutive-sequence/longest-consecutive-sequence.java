/*
Intuition:
Put all the numbers in a HashSet
if the number - 1 is present in the hashset, it means the sequence is present before int
so dont check
otherwise traverse and keep track of the maxLen
*/

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

