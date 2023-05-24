class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap< Integer,Integer > map = new HashMap();

        for(int i: arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        for(int key: map.keySet()) {
            int value = map.get(key);
            int[] res = new int[]{key,value};
            pq.add(res);
        }

        for(int i = 0; i < k; i++) {
            int[] ele = pq.poll();
            if(ele[1] > 1){
                ele[1]--;
                pq.add(ele);
            }
        }

        return pq.size();
    }
}