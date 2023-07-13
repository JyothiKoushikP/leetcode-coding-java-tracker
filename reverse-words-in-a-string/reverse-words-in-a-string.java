class Solution {
    public String reverseWords(String s) {
       StringBuilder result = new StringBuilder();
       String modified = s.replaceAll("\\s+"," ");
       String[] res = modified.split(" ");
       for(int i=res.length-1;i>=0;i--){
           result.append(res[i]);
           result.append(" ");
       }
       return result.toString().trim();
    }
}