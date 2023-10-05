class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> romanMap = new HashMap();
        romanMap.put('0',0);
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        int sum = 0;
        char lastChar = '0';
        int n = s.length();
        for(int i = n - 1; i>= 0; i--) {
            char ch = s.charAt(i);
            if(romanMap.get(ch) >= romanMap.get(lastChar)){
                sum += romanMap.get(ch);
            } else {
                sum -= romanMap.get(ch);
            }
            lastChar = ch;
        }

        return sum;
    }
}