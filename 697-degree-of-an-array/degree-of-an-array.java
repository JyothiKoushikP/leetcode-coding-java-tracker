class Solution {
    public int findShortestSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        HashMap<Integer,int[]> result = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(!result.containsKey(nums[i])) {
                int[] info = new int[3];
                info[0]++;
                max = Math.max(max,info[0]);
                info[1] = i;
                info[2] = i;
                result.put(nums[i],info);
            } else {
                int[] info = result.get(nums[i]);
                info[0]++;
                max = Math.max(max,info[0]);
                info[2] = i;
                result.put(nums[i],info);
            }
        }

        int window = Integer.MAX_VALUE;
        for(int i: result.keySet()) {
            int[] info = result.get(i);
            if(info[0] == max) {
                window = Math.min(window,(info[2]-info[1]) + 1);
            }
        }

        return window;
    }
}