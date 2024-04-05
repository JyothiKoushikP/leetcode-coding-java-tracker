class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int maxLen = 0;
        int cost = 0;
        int left = 0, right = 0;
        while(right < s.length()) {
            cost += Math.abs((s.charAt(right) - 'a') - (t.charAt(right) - 'a'));
            while(cost > maxCost) {
                cost -= Math.abs((s.charAt(left) - 'a') - (t.charAt(left) - 'a'));
                left++;
            }
            maxLen = Math.max(maxLen,right - left + 1);
            right++;
        }
        return maxLen;
    }
}