class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted_s = new String(charArray);
            if (!m.containsKey(sorted_s)) {
                m.put(sorted_s, new ArrayList<>());
            }
            m.get(sorted_s).add(s);
        }
        return new ArrayList<>(m.values());
    }
}