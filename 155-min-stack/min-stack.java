class MinStack {

    private Stack<int[]> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        int currentMin = getMin();
        if(val < currentMin) {
            minStack.push(new int[]{val,val});
        } else {
            minStack.push(new int[]{val,currentMin});
        }
    }
    
    public void pop() {
        if(!minStack.isEmpty()) {
            minStack.pop();
        }
    }
    
    public int top() {
        if(!minStack.isEmpty()) {
            return minStack.peek()[0];
        }
        return 0;
    }
    
    public int getMin() {
        if(!minStack.isEmpty()) {
            return minStack.peek()[1];
        }
        return Integer.MAX_VALUE;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */