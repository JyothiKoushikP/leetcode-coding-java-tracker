class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<String,List<String>> mappings = new HashMap<>();
        generateMappings(mappings);
        String processed = "";
        List<String> result = new ArrayList();
        if(digits.length() == 0) {
            return result;
        }
        result = generateCombinations(0,mappings,digits,processed);
        return result;
    }

    public static List<String> generateCombinations(int startPointer, HashMap<String,List<String>>      mappings, String digits, String processed) {
        if(startPointer == digits.length()) {
            List<String> f = new ArrayList<>();
            f.add(processed.toString());
            return f;
        }
        List<String> total = new ArrayList<>();
        char c = digits.charAt(startPointer);
        List<String> map = mappings.get(Character.toString(c));
        for(int j = 0; j < map.size(); j++) {
            String p = processed + map.get(j);
            total.addAll(generateCombinations(startPointer+1,mappings,digits,p));
        }

        return total;
    }

    public static void generateMappings(HashMap<String,List<String>> mappings) {
        int start = 2, end = 9;
        int x = 0;
        while(start <= end) {
            int n = 3;
            if(start == 7 || start == 9) {
                n += 1;
            }
            List<String> alphabets = new ArrayList<>();
            for(int i =0; i < n; i++) {
                char ch = (char)('a' + x);
                x++;
                alphabets.add(Character.toString(ch));
            }
            mappings.put(Integer.toString(start),alphabets);
            start++;
        }
    }
}