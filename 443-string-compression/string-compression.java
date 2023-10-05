class Solution {
    public int compress(char[] chars) {
        int i = 0, index = 0;

        while(i < chars.length) {
            int position = i;
            while(position < chars.length && chars[position] == chars[i]){
                position++;
            }
            chars[index++] = chars[i];

            if((position - i) > 1) {
                String s = Integer.toString((position - i));
                for(char c: s.toCharArray()) {
                    chars[index++] = c;
                }
            }
            i = position;
        }

        return index;
    }
}