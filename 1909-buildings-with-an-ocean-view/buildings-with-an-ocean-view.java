class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        Stack<Integer> bh = new Stack<Integer>();
        bh.push(n-1);
        for(int i = n-2 ; i >= 0; i--) {
            if(heights[i] > heights[bh.peek()]) {
                bh.push(i);
            }
        }
        int[] result = new int[bh.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = bh.pop();
        }
        return result;
    }
}