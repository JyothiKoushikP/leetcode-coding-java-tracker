class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != '0' && grid[i][j] != '@') {
                    calculateIsland(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void calculateIsland(char[][] map,int r, int c) {
        if(r < 0 || r >= map.length || c < 0 || c >= map[0].length) {
            return;
        }
        if(map[r][c] == '0' || map[r][c] == '@') {
            return;
        }
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] directions: dir) {
            map[r][c] = '@';
            calculateIsland(map,r + directions[0],c + directions[1]);
        }
    }
}