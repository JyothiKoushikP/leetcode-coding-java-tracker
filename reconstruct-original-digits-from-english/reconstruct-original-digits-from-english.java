class Solution {
    public String originalDigits(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()) {
            freq[c-'a']++;
        }
        int[] numbers = new int[10];

        if(s.indexOf('z') != -1) {
            numbers[0] = freq['z'-'a'];
            freq['z'-'a'] = 0;
            freq['e'-'a'] -= numbers[0];
            freq['r'-'a'] -= numbers[0];
            freq['o'-'a'] -= numbers[0];
        }

        if(s.indexOf('w') != -1) {
            numbers[2] = freq['w'-'a'];
            freq['w'-'a'] = 0;
            freq['t'-'a'] -= numbers[2];
            freq['o'-'a'] -= numbers[2];
        }

        if(s.indexOf('u') != -1) {
            numbers[4] = freq['u'-'a'];
            freq['u'-'a'] = 0;
            freq['f'-'a'] -= numbers[4];
            freq['o'-'a'] -= numbers[4];
            freq['r'-'a'] -= numbers[4];
        }

        if(s.indexOf('x') != -1) {
            numbers[6] = freq['x'-'a'];
            freq['x'-'a'] = 0;
            freq['i'-'a'] -= numbers[6];
            freq['s'-'a'] -= numbers[6];
        }

        if(s.indexOf('g') != -1) {
            numbers[8] = freq['g'-'a'];
            freq['g'-'a'] = 0;
            freq['e'-'a'] -= numbers[8];
            freq['i'-'a'] -= numbers[8];
            freq['h'-'a'] -= numbers[8];
            freq['t'-'a'] -= numbers[8];
        }

        if(freq['s'-'a'] != 0) {
            numbers[7] = freq['s'-'a'];
            freq['s'-'a'] = 0;
            freq['e'-'a'] -= (2 * numbers[7]);
            freq['v'-'a'] -= numbers[7];
            freq['n'-'a'] -= numbers[7];
        }

        if(freq['f'-'a'] != 0) {
            numbers[5] = freq['f'-'a'];
            freq['f'-'a'] = 0;
            freq['i'-'a'] -= numbers[5];
            freq['v'-'a'] -= numbers[5];
            freq['e'-'a'] -= numbers[5];
        }

        if(freq['t'-'a'] != 0) {
            numbers[3] = freq['t'-'a'];
            freq['t'-'a'] = 0;
            freq['h'-'a'] -= numbers[3];
            freq['r'-'a'] -= numbers[3];
            freq['e'-'a'] -= (2* numbers[3]);
        }

        if(freq['o'-'a'] != 0) {
            numbers[1] = freq['o'-'a'];
            freq['o'-'a'] = 0;
            freq['n'-'a'] -= numbers[1];
            freq['e'-'a'] -= numbers[1];
        }

        numbers[9] = freq['n'-'a']/2;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            int f = numbers[i];
            for(int j = 0;j< f;j++) {
                sb.append((char)(i+'0'));
            }
        }

        return sb.toString();
    }
}