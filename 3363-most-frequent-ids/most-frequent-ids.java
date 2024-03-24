class Solution {
    class State{
        public int id;
        public long count;
        public State(int id, long count){
            this.id = id;
            this.count = count;
        }
    }
    private Map<Integer, Long> map;
    private PriorityQueue<State> pq;
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        long[] ans = new long[nums.length];
        map = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> { return Long.compare(b.count, a.count); });
        
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 0L);
            }
            map.put(nums[i], map.get(nums[i]) + freq[i]);
            pq.offer(new State(nums[i], map.get(nums[i])));
            
            while(pq.size() > 0){
                State cur = pq.peek();
                if(map.get(cur.id) == cur.count){ //Get the legit answer and also the max one.
                    ans[i] = cur.count;
                    break;
                }
                pq.poll();
            }
        }
        return ans;
    }
}