class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : nums2){
            map.put(i*k,map.getOrDefault(i*k,0)+1);
        }
        
        for (int i : nums1){
            for (int j = 1;j <= Math.sqrt(i);j++){
                if (i%j==0){
                    int val = i/j;
                    if (map.containsKey(j))count+= map.get(j);
                    if (val != j && map.containsKey(val))count+= map.get(val);
                }
            }
        }
        return count;
    }
}