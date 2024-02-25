class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> str = new Stack<Integer>();
        Stack<Integer> par = new Stack<Integer>();
        for(int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                str.push(i);
                par.push(i);
            } else if (c == ')') {
                if(!par.isEmpty()) {
                    str.push(i);
                    par.pop();
                }
            } else {
                str.push(i);
            }
        }
        while(!str.isEmpty()) {
            int index = par.isEmpty() ? -1 : par.peek();
            if(str.peek() != index) {
                res.insert(0,s.charAt(str.pop()));
            } else {
                str.pop();
                par.pop();
            }
        }
        return res.toString();
    }
}