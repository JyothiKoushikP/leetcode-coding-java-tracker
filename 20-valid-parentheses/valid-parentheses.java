class Solution {
    public boolean isValid(String s) {
        Stack<Character> paranthesis = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                paranthesis.push(c);
            } else  {
                if(paranthesis.isEmpty()) {
                    return false;
                }

                if((paranthesis.peek() == '(' && c == ')') || (paranthesis.peek() == '{' && c == '}') || (paranthesis.peek() == '[' && c == ']')) {
                    paranthesis.pop();
                } else {
                    return false;
                }
            }
        }
        return paranthesis.isEmpty();
    }
}