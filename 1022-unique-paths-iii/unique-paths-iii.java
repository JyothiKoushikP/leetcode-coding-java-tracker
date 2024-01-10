class Solution {
    public int uniquePathsIII(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int totalVisited = 0, sR = 0, sC = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    sR = i;
                    sC = j;
                }
                if(grid[i][j] != -1) totalVisited++;
            }
        }
        return uniquePaths(grid, visited, 1,totalVisited,sR,sC);
    }

    public static int uniquePaths(int[][] grid, int[][] visited, int totalVisited, int totalCount, int r, int c) {
        int count = 0;
        if(visited[r][c] == 1 || grid[r][c] == -1) {
            return 0;
        }
        if(grid[r][c] == 2) {
            if(totalVisited == totalCount) {
                return 1;
            }
            return 0;
        }
        visited[r][c] = 1;
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] d: directions) {
            int nR = r + d[0], nC = c + d[1];
            boolean outOfBounds = nR < 0 || nR >= grid.length || nC < 0 || nC >= grid[0].length;
            if(!outOfBounds && visited[nR][nC] != 1) {
                count += uniquePaths(grid,visited,totalVisited + 1,totalCount,nR,nC);
                visited[nR][nC] = 0;
            }
        }
        return count;
    }
}