class Solution {
    public int evalRPN(String[] tokens) {
        List<String> operands = new ArrayList();
        operands.add("+"); 
        operands.add("-");
        operands.add("*");
        operands.add("/");
        Stack<Integer> tStack = new Stack<Integer>();
        for(String token: tokens) {
            if(operands.contains(token)) {
                int x1 = tStack.pop();
                int x2 = tStack.pop();
                int res = calculation(x2,x1,token);
                tStack.push(res);
            } else {
                int x = Integer.valueOf(token);
                tStack.push(x);
            }
        }
        return tStack.peek();
    }

    public int calculation(int x1, int x2, String op) {
        int res = 0;
        switch(op) {
            case "+":
                res = x1 + x2;
                break;
            case "-":
                res = x1 - x2;
                break;
            case "*":
                res = x1 * x2;
                break;
            case "/":
                res = x1 / x2;
                break;
        }
        return res;
    }
}