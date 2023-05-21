class Solution {
    public int orangesRotting(int[][] grid1) {
        return orangeGridFunction(0, grid1);
    }

    public int orangeGridFunction(int min,int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] original = new int[m][n];
        int oranges = 0;
        
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++) {
                original[i][j] = grid[i][j];
                if(original[i][j] == 1) {
                    oranges++;
                }
            }
        }

        if(oranges == 0) {
            return min;
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++) {
                if(grid[i][j] == 2 && original[i][j] == 2) {
                    if(i > 0) {
                        if(grid[i-1][j] == 1){
                            grid[i-1][j] = 2;
                            oranges--;
                        }
                    }
                    if(i < m-1) {
                        if(grid[i+1][j] == 1){
                            grid[i+1][j] = 2;
                            oranges--;
                        }
                    }
                    if(j > 0) {
                        if(grid[i][j-1] == 1){
                            grid[i][j-1] = 2;
                            oranges--;
                        }
                    }
                    if(j < n-1) {
                        if(grid[i][j+1] == 1){
                            grid[i][j+1] = 2;
                            oranges--;
                        }
                    }
                }
            }
        }

        if(oranges == 0) {
            return min+1;
        }

        if(isEqual(original,grid) && oranges != 0) {
            return -1;
        }

        return orangeGridFunction(min+1,grid);
    }

    public boolean isEqual(int[][] org, int[][] modified) {
        int m = org.length;
        int n = org[0].length;
        for(int i = 0;i < m; i++) {
            for(int j = 0;j < n;j++) {
                if(org[i][j] != modified[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}