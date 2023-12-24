class Solution {
    public int getMaximumGold(int[][] matrix) {
        int maxGold = 0;
        for(int i = 0; i < matrix.length ; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] != 0) {
                    maxGold = Math.max(maxGold,pathWithMaximumSum(matrix,0,i,j,0));
                }
            }
        }
        return maxGold;  
    }

    
 public int pathWithMaximumSum(int[][] grid, int goldSum, int r, int c, int maxSum) {
        if(r >= grid.length || c >= grid[0].length || r < 0 || c < 0 || grid[r][c] == -1 || grid[r][c] == 0) {
            return goldSum;
        }
        int[][] dir = new int[][]{ {0,1},{1,0},{0,-1},{-1,0} };
        for(int i = 0; i < dir.length ; i++) {
            int gold = grid[r][c];
            goldSum += gold;
            grid[r][c] = -1;
            maxSum = Math.max(maxSum,pathWithMaximumSum(grid,goldSum,r + dir[i][0],c + dir[i][1],maxSum));
            grid[r][c] = gold;
            goldSum -= gold;
        }

        return maxSum;
    }

}