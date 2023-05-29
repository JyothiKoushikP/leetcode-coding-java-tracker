class Solution {
    public String addBinary(String a, String b) {
        int numberOfOnesA = 0, numberOfOnesB = 0;
        for(char c: a.toCharArray()) {
            if(c == '1') numberOfOnesA++;
        }
        for(char c: b.toCharArray()) {
            if(c == '1') numberOfOnesB++;
        }
        if(numberOfOnesA == 0){
            return b;
        }
        if(numberOfOnesB == 0){
            return a;
        }
        return a.length() >= b.length() ? calculateSum(a,b) : calculateSum(b,a);
    }

    public String calculateSum(String a, String b) {
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        while(l1 >= 0 || l2 >= 0) {
            int x = l1 >= 0 ? a.charAt(l1) - '0' : 0;
            int y = l2 >= 0 ? b.charAt(l2) - '0' : 0;
            int sum = x + y + carry;
            if(sum == 0) {
                res.insert(0,'0');
                carry = 0;
            } else if (sum == 1) {
                res.insert(0,'1');
                carry = 0;
            } else if (sum == 2) {
                res.insert(0,'0');
                carry = 1;
            } else if (sum == 3) {
                res.insert(0,'1');
                carry = 1;
            }
            l1--;
            l2--;
        }
        if(carry != 0) {
            res.insert(0,(char)(carry+'0'));
        }
        return res.toString();
    }

}