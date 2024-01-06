class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0;j < grid[0].length; j++) {
                if(grid[i][j] != 0 && grid[i][j] != -1) {
                    maxArea = Math.max(maxArea,calculateArea(grid,0,i,j)/4);
                }
            }
        }
        return maxArea;
    }

    public int calculateArea(int[][] map, int area,int r, int c) {
        int count = 0;
        if(r < 0 || r >= map.length || c < 0 || c >= map[0].length) {
            return area;
        }
        if(map[r][c] == 0 || map[r][c] == -1) {
            return area;
        }
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] directions: dir) {
            map[r][c] = -1;
            int val = calculateArea(map,area + 1,r + directions[0],c + directions[1]);
            area = Math.max(area,val);
        }
        return area;
    }
}