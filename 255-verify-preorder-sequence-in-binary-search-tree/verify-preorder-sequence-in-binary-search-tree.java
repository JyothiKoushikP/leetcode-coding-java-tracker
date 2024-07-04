class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> s = new Stack<>();
        int minLimit = Integer.MIN_VALUE;
        for(int i : preorder) {
            while (!s.isEmpty() && s.peek() < i) {
                minLimit = s.pop();
            }
            if(minLimit >= i) {
                return false;
            }
            s.push(i);
        }
        return true;
    }
}