class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        ArrayList<String> result = new ArrayList();
        int startPointer = 0,n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            sb.append(c);
            if(i-startPointer+1 == 10){
                if(set.contains(sb.toString()) && !result.contains(sb.toString())){
                    result.add(sb.toString());
                } else {
                    set.add(sb.toString());
                }
                sb.deleteCharAt(0);
                startPointer++;
            }
        }
        return result;
    }
}