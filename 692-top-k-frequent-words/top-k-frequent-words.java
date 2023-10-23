class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> freq = new HashMap();
        for(String word: words) {
            freq.put(word,freq.getOrDefault(word,0) + 1);
        }
        List<String>[] result = new List[words.length + 1];
        for(String key: freq.keySet()) {
            int f = freq.get(key);
            if(result[f] == null) result[f] = new ArrayList<>();
            result[f].add(key);
        }

        int count = 0;
        List<String> res = new ArrayList<String>();
        for(int i = words.length; i >= 0; i--) {
            if(result[i] != null) {
                int j = 0;
                Collections.sort(result[i]);
                while(j < result[i].size() && count < k) {
                    res.add((result[i]).get(j));
                    j++;
                    count++;
                }
            }
        }
        return res;

    }
}