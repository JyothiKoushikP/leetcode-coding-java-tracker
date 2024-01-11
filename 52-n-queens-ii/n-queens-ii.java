class Solution {
    public int totalNQueens(int n) {
        int[][] grid = new int[n][n];
        return calculateTotalWays(grid,0,n);
    }

    public int calculateTotalWays(int[][] grid, int row, int n) {
        int count = 0;
        if(row == n) {
            return 1;
        }

        for(int i = 0; i < n; i++) {
            if(isValidPosition(grid,row,i)) {
                grid[row][i] = 1;
                count += calculateTotalWays(grid,row + 1,n);
            }
            grid[row][i] = 0;
        }
        return count;
    }

    public boolean isValidPosition(int[][] grid, int row, int col) {
        for(int i = 0; i < grid[0].length; i++) {
            if(grid[row][i] == 1 && i != col) {
                return false;
            }
        }

        for(int i = 0; i < grid.length; i++) {
            if(grid[i][col] == 1 && i != row) {
                return false;
            }
        }

        int i = row -1 , j = col - 1;
        while(i >= 0 && j >= 0) {
            if(grid[i][j] == 1) return false;
            i--;
            j--;
        }

        i = row -1; j = col + 1;
        while(i >= 0 && j < grid[0].length) {
            if(grid[i][j] == 1) return false;
            i--;
            j++;
        }

        return true;
    }
}