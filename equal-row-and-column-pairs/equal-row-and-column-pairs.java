class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int total = 2 * n;
        HashMap<String, Integer> result = new HashMap();

        for(int i = 0; i < n; i++) {
            StringBuilder res = new StringBuilder();
            for(int j = 0; j < n; j++) {
                res.append(Integer.toString(grid[i][j]));
                res.append("@");
            }
            result.put(res.toString(),result.getOrDefault(res.toString(),0) + 1);
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            StringBuilder res = new StringBuilder();
            for(int j = 0; j < n; j++) {
                res.append(Integer.toString(grid[j][i]));
                res.append("@");
            }
            if(result.containsKey(res.toString())) {
                count += result.get(res.toString());
            }
        }

        return count;
    }
}