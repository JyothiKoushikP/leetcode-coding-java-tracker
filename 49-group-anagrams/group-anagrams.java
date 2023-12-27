class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap();
        for(String str: strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sorted = String.valueOf(ch);
            if(!map.containsKey(sorted)) {
                map.putIfAbsent(sorted,new ArrayList());
            } 
            map.get(sorted).add(str);
        }
        List<List<String>> result = new ArrayList();
        for(String c: map.keySet()) {
            result.add(map.get(c));
        }
        return result;
    }
}