class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        Map<Character,Integer> roman = new HashMap();
        roman.put('@',0);
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);

        char prev = '@';

        for(int i = s.length()-1; i>=0 ;i--) {
            if(roman.get(s.charAt(i)) < roman.get(prev)) {
                sum -= roman.get(s.charAt(i));
            } else {
                sum += roman.get(s.charAt(i));
            }
            prev = s.charAt(i);
        }

        return sum;
    }
}