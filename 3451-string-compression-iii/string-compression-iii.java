class Solution {
    public String compressedString(String word) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while (i < word.length()) {
            char current = word.charAt(i);
            int it = i;
            int count = 0;

            while (it < word.length() && word.charAt(it) == current) {
                it++;
                count++;
            }

            int q = count / 9;
            count = count % 9;

            while (q > 0) {
                result.append(9);
                result.append(current);
                q--;
            }

            if (count != 0) {
                result.append(count);
                result.append(current);
            }

            i = it;
        }

        return result.toString();
    }
}