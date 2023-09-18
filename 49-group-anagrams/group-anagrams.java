class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList> res = new HashMap<>();
        for(String str: strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sorted = String.valueOf(ch);
            if(!res.containsKey(sorted)){
                res.put(sorted, new ArrayList<>());
            }
            (res.get(sorted)).add(str);
        } 

        return new ArrayList(res.values());
    }
}