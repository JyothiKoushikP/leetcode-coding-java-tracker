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
        StringBuilder[][] track = new StringBuilder[board.length][board[0].length];
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    track[i][j] = new StringBuilder("NN");
                }
            }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int liveNeighbors = 0;
                for(int[] direction: dir) {
                    int nr = i + direction[0];
                    int nc = j + direction[1];
                    if ((nr >= 0 && nr < board.length) && (nc >= 0 && nc < board[0].length)) {
                        if (track[nr][nc].charAt(0) == 'Y') {
                            if (track[nr][nc].charAt(1) == 'Y') {
                                liveNeighbors += (board[nr][nc] == 1) ? 0 : 1;
                            } else {
                                liveNeighbors += board[nr][nc];
                            }
                        } else {
                            liveNeighbors += board[nr][nc];
                        }
                    }

                }
/*
0 1 0
0 0 1
1 1 1
0 0 0 */
                    if(board[i][j] == 0) {
                        if(liveNeighbors == 3) {
                            board[i][j] = 1;
                            track[i][j].setCharAt(1,'Y');
                        } else {
                            track[i][j].setCharAt(1,'N');
                        }
                    } else {
                        if(liveNeighbors > 3 || liveNeighbors < 2) {
                            board[i][j] = 0;
                            track[i][j].setCharAt(1,'Y');
                        } else {
                            track[i][j].setCharAt(1,'N');
                        }
                    }
                    track[i][j].setCharAt(0,'Y');
                }
            }
    }
}