class Solution {
    public int maxLength(List<String> arr) {
        Map<Character,Integer> freq = new HashMap();
        return maxLengthCombinations(arr,0,freq);
    }

    public int maxLengthCombinations(List<String> arr, int pointer, Map<Character,Integer> freq) {
        for(int i: freq.values()) {
            if(i > 1) return 0;
        }
        int best = freq.size();
        for(int i = pointer; i < arr.size(); i++) {
            char[] charArray = (arr.get(i)).toCharArray();
            for(char c: charArray) {
                freq.put(c,freq.getOrDefault(c,0) + 1);
            }
            best = Math.max(best, maxLengthCombinations(arr,i+1,freq));
            for(char c: charArray) {
                if(freq.get(c) == 1) {
                    freq.remove(c);
                } else {
                    freq.put(c,freq.get(c) - 1);
                }
            }
        }
        return best;
    }

}