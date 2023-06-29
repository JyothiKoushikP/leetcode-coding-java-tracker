class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0) {
                    dfs(rooms,i,j,0);
                }
            }
        }
    }

    public void dfs(int[][] rooms, int row, int col, int distance) {
        if(row >= rooms.length || row<0 || col >=rooms[0].length || col<0 || rooms[row][col] == -1) {
            return;
        }

        if(rooms[row][col]<=distance && distance !=0) {
            return;
        }

        rooms[row][col] = distance;

        dfs(rooms,row+1,col,distance+1);
        dfs(rooms,row,col+1,distance+1);
        dfs(rooms,row-1,col,distance+1);
        dfs(rooms,row,col-1,distance+1);
    }

    
}