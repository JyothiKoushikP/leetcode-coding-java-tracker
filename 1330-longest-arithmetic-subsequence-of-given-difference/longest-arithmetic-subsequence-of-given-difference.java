class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int maxLength = 0;
        Map<Integer,Integer> diff = new HashMap<>();
        for(int i: arr) {
            if(diff.containsKey(i-difference)) {
                diff.put(i, diff.get(i-difference) + 1);
                maxLength = Math.max(maxLength, diff.get(i));
            } else {
                diff.put(i, 0);
            }
        }
        return maxLength + 1;
    }
}