class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> freq = new HashMap();
        List<Character>[] buckets = new List[s.length() + 1];

        for(char c: s.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0) + 1);
        }

        for(char c: freq.keySet()) {
            int f = freq.get(c);
            if(buckets[f] == null) {
                buckets[f] = new ArrayList<Character>();
            }
            buckets[f].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = s.length(); i>=0 ; i--) {
            if(buckets[i] != null) {
                for(char c: buckets[i]) {
                    int j = 0;
                    while(j < i) {
                        sb.append(c);
                        j++;
                    }
                }
            }
        }
        return sb.toString();
    }
}