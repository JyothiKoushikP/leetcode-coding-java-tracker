class FirstUnique {
    Map<Integer,Boolean> freq = new HashMap<>();
    Queue<Integer> q = new LinkedList<>();

    public FirstUnique(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(!freq.containsKey(nums[i])) {
                freq.put(nums[i],true);
                q.add(nums[i]);
            } else {
                freq.put(nums[i],false);
            }
        }
    }
    
    public int showFirstUnique() {
        while(!q.isEmpty() && !freq.get(q.peek())) {
            q.remove();
        }
        return q.isEmpty() ? -1 : q.peek();

    }
    
    public void add(int value) {
        if(!freq.containsKey(value)) {
            freq.put(value,true);
            q.add(value);
        } else {
            freq.put(value,false);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */