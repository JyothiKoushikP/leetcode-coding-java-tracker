class Solution {
    public List<String> letterCasePermutation(String s) {
        String processed = "";
        List<String> result = new ArrayList<>();
        letterCasePermutation(s,0,result,processed);
        return result;
    }

    public void letterCasePermutation(String input, int pointer,List<String> result, String processed) {
        if(pointer == input.length()) {
            result.add(processed);
            return;
        }
        char c = input.charAt(pointer);
        if(Character.isDigit(c)) {
            letterCasePermutation(input,pointer + 1,result,processed + c);
        } else {
            letterCasePermutation(input,pointer + 1,result,processed + Character.toLowerCase(c));
            letterCasePermutation(input,pointer + 1,result,processed + Character.toUpperCase(c));
        }
    }

}