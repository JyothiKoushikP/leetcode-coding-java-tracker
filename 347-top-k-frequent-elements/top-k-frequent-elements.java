class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap();
        for(int i: nums) {
            freq.put(i,freq.getOrDefault(i,0) + 1);
        }
        List<Integer>[] result = new List[nums.length + 1];
        for(int key: freq.keySet()) {
            int f = freq.get(key);
            if(result[f] == null) result[f] = new ArrayList<>();
            result[f].add(key);
        }

        int[] res = new int[k];
        int j = 0;
        for(int i = nums.length; i >= 0 && j < k; i--) {
            if(result[i] != null) {
                for(int ele: result[i]) {
                    res[j++] = ele;
                }
            }
        }
        
        return res;
    }
}