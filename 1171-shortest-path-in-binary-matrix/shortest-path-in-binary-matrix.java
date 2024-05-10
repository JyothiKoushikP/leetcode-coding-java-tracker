class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        int[][] track = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        track[0][0] = 1;
        q.add(new int[]{0,0});
        int[][] dirs = new int[][] {{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0}};
        while (!q.isEmpty()) {
            int[] current = q.remove();
            int x = current[0];
            int y = current[1];
            int val = track[x][y];
            for(int[] dir: dirs) {
                int cX = x + dir[0];
                int cY = y + dir[1];
                if(cX >= 0 && cX < m && cY >= 0 && cY < n && grid[cX][cY] != 1) {
                    track[cX][cY] = val + 1;
                    q.add(new int[]{cX,cY});
                    grid[cX][cY] = 1;
                }
            }
        }
        return track[m-1][n-1] == 0 ? -1 : track[m-1][n-1];
    }
}