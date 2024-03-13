class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int sd = Integer.MAX_VALUE;
        List<Integer> arr = new ArrayList<Integer>();
        List<Integer> arr2 = new ArrayList<Integer>();
        for(int i = 0; i < wordsDict.length; i++) {
            if(wordsDict[i].equals(word1)) {
                arr.add(i);
            } else if(wordsDict[i].equals(word2)) {
                arr2.add(i);
            }
        }

        for(int i : arr) {
            for(int j : arr2) {
                int d = Math.abs(i - j);
                sd = Math.min(sd,d);
            }
        }

        return sd;
    }
}