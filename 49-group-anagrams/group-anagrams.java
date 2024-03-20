class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> track = new HashMap<>();
        for(String s: strs) {
            int[] freq = new int[26];
            for(char c: s.toCharArray()) {
                freq[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int num: freq) {
                sb.append(num);
                sb.append("#");
            }
            track.putIfAbsent(sb.toString(),new ArrayList<>());
            track.get(sb.toString()).add(s);
        }
        return new ArrayList<>(track.values());
    }
}