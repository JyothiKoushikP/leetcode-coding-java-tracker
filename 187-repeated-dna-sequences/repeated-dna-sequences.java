class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0, n = s.length();
        HashMap<String,Integer> dna = new HashMap();
        List<String> result = new ArrayList();
        for(int i = 0; i < n ; i++) {
            char ch = s.charAt(i);
            sb.append(ch);
            if((i - start) + 1 == 10) {
                dna.put(sb.toString(),dna.getOrDefault(sb.toString(),0) + 1);
                sb.deleteCharAt(0);
                start++;
            }
        }
        for(String pattern: dna.keySet()) {
            if(dna.get(pattern) > 1){
                result.add(pattern);
            }
        }

        return result;
    }
}