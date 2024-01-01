class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dir = {
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {0, -1},
                {0, 1},
                {1, -1},
                {1, 0},
                {1, 1}
        };
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int liveNeighbors = 0;
                for(int[] direction: dir) {
                    int nr = i + direction[0];
                    int nc = j + direction[1];
                    if ((nr >= 0 && nr < board.length) && (nc >= 0 && nc < board[0].length)) {
                       if(board[nr][nc] == 2) {
                           liveNeighbors += 0;
                       } else if(board[nr][nc] == -1){
                           liveNeighbors += 1;
                       } else {
                           liveNeighbors += board[nr][nc];
                       }
                    }
                }
                    if(board[i][j] == 0) {
                        if(liveNeighbors == 3) {
                            board[i][j] = 2;
                        }
                    } else {
                        if(liveNeighbors > 3 || liveNeighbors < 2) {
                            board[i][j] = -1;
                        }
                    }
                }
            }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 2){
                    board[i][j] = 1;
                } else if(board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }
}