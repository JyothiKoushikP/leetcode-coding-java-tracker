class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        Map<Integer,int[]> positions = new HashMap<>();
        int degree = 0;
        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];
            freq.put(x, freq.getOrDefault(x,0) + 1);
            degree = Math.max(degree, freq.get(x));
            if(!positions.containsKey(x)) {
                positions.put(x, new int[]{-1,-1});
            }
            if(positions.get(x)[0] == -1) {
                positions.get(x)[0] = i;
                positions.get(x)[1] = i;
            } else {
                positions.get(x)[1] = i;
            }
        }
        int leastDistance = Integer.MAX_VALUE;
        for(int i: positions.keySet()) {
            int[] pos = positions.get(i);
            if(freq.get(i) == degree) {
                leastDistance = Math.min(pos[1]-pos[0] + 1,leastDistance);
            }
        }
        return leastDistance;
    }
}