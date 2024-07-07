class Solution {
    int[][] dirs = new int[][] {{0,1},{0,-1},{-1,0},{1,0}};
    public void solve(char[][] board) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(!visited[i][j] && (i == 0 || i == board.length - 1 || j == 0 || j== board[0].length - 1) && board[i][j] == 'O') {
                    dfs(board,visited,i,j);
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

        return;
    }

    public void dfs(char[][] board, boolean visited[][], int r, int c) {
        visited[r][c] = true;
        for(int[] dir: dirs) {
            int nR = r + dir[0], nC = c + dir[1];
            if(!(nR < 0 || nR >= board.length || nC < 0 || nC >= board[0].length)) {
                if(board[nR][nC] != 'X' && !visited[nR][nC]) {
                    dfs(board,visited,nR,nC);
                }
            }
        }

        return;
    }
}