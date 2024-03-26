class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,new Comparator<>() {
            @Override
            public int compare(int[] c1, int[] c2) {
                int i = Integer.compare(c1[0],c2[0]);
                return i;
            }
        });
        int[][] relativeCosts = new int[costs.length][];
        for(int i = 0; i < costs.length; i++) {
            int diff = costs[i][1] - costs[i][0];
            relativeCosts[i] = new int[]{costs[i][0],costs[i][1],diff};
        }
        Arrays.sort(relativeCosts,new Comparator<>() {
            @Override
            public int compare(int[] c1, int[] c2) {
                return Integer.compare(c2[2],c1[2]);
            }
        });
        int aCount = costs.length/2, minCost = 0;
        for(int[] rl : relativeCosts) {
            if(aCount != 0) {
                minCost += rl[0];
                aCount--;
            } else {
                minCost += rl[1];
            }
        }
        return minCost;
    }
}