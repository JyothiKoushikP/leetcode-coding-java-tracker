class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        generateParanthesisRecursion("",n,n,0,result);
        return result;
    }

    public void generateParanthesisRecursion(String brackets, int open, int closed, int balance, List<String> result) {
        if(open == 0 && closed == 0) {
            result.add(brackets);
            return;
        }
        if(balance == 0) {
            generateParanthesisRecursion(brackets + "(",open-1,closed,balance + 1,result);
        } else {
            if(open != 0 && closed != 0) {
                generateParanthesisRecursion(brackets + "(",open - 1,closed,balance + 1,result);
                generateParanthesisRecursion(brackets + ")",open,closed-1,balance-1,result);
            } else if(open == 0) {
                generateParanthesisRecursion(brackets + ")",open,closed-1,balance-1,result);
            }
        }
    }
}