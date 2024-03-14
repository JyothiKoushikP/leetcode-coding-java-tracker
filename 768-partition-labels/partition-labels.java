class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> track = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            track.put(c,i);
        }
        int left = 0, right = 0, maxLength = 0;
        List<Integer> result = new ArrayList<>();
        while(right < s.length()) {
            char c = s.charAt(right);
            maxLength = Math.max(maxLength,track.get(c));
            if(right == maxLength) {
                result.add((right - left) + 1);
                left = right + 1;
            }
            right++;
        }
        return result;
    }
}
