class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> brackets = new HashMap();
        brackets.put(')','(');
        brackets.put(']','[');
        brackets.put('}','{');
        Stack<Character> p = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '[' || c == '{' || c == '(') {
                p.push(c);
            } else {
                if(p.isEmpty() || p.peek() != brackets.get(c)) {
                    return false;
                } else {
                    p.pop();
                }
            }
        }
        return p.isEmpty() ? true: false;
    }
}