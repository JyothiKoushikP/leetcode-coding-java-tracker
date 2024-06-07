class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int column) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
            return;
        }
        if(grid[row][column] == '1') {
            grid[row][column] = 'X';
        } else {
            return;
        }
        for(int[] dir: dirs) {
            dfs(grid,row + dir[0],column + dir[1]);
        }
        return;
    }
}