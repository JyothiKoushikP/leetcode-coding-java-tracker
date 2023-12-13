class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        partitionPalindrome(result,partition,s,0);
        return result;

    }

    public static void partitionPalindrome(List<List<String>> result,List<String> partition, String s, int index) {
        if(index == s.length()){
            List<String> res = new ArrayList<>();
            for(String p : partition){
                res.add(p);
            }
            result.add(res);
            return;
        }

        for(int i = index + 1; i <= s.length(); i++) {
                String sub = s.substring(index,i);
                if(checkPalindrome(sub)){
                    partition.add(sub);
                    partitionPalindrome(result,partition,s,i);
                    partition.remove(partition.size() - 1);
                }
        }

    }



    public static boolean checkPalindrome (String s){
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}