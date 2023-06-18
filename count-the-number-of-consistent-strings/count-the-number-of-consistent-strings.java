class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int sum = 0;
        for(String word: words){
            if(isConsistent(word,allowed)){
                sum++;
            }
        }
        return sum;
    }

    public boolean isConsistent(String word, String allowed){
        for(char c: word.toCharArray()){
            if(!allowed.contains(Character.toString(c))){
                return false;
            }
        }
        return true;
    }
}