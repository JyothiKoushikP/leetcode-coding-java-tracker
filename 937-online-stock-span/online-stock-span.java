class StockSpanner {
    Stack<int[]> sStack;

    public StockSpanner() {
       sStack = new Stack<>();
    }
    
    public int next(int price) {
        List<int[]> sList = new ArrayList();
        int ans = 1;
        while(!sStack.isEmpty() && sStack.peek()[0] <= price){
            ans += sStack.pop()[1];
        }

        sStack.push(new int[]{price,ans});
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */