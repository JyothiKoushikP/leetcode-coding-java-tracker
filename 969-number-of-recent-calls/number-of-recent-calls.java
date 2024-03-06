class RecentCounter {
    Queue<Integer> counter;

    public RecentCounter() {
        counter = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        int lowerBound = t - 3000;
        while(!counter.isEmpty() && counter.peek() < lowerBound) {
            counter.remove();
        }
        counter.add(t);
        return counter.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */