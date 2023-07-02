class TicTacToe {
    int[][] gameBoard;
    public TicTacToe(int n) {
        gameBoard = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        int n = gameBoard.length;
        gameBoard[row][col] = player;

        int i = 0;

        while(i < n) {
            if(gameBoard[row][i] != player){
                break;
            }
            i++;
        }

        if(i == n) {
            return player;
        }

        i = 0;

        while(i < n) {
            if(gameBoard[i][col] != player){
                break;
            }
            i++;
        }

        if(i == n) {
            return player;
        }

        i = 0;

        if(row == col) {
            while(i < n) {
                if(gameBoard[i][i] != player) {
                    break;
                }
                i++;
            }
            
            if(i == n) {
                return player;
            }
        }

        i = 0;

        if(row + col == n-1) {
            while(i < n) {
                if(gameBoard[i][(n-1)-i] != player) {
                    break;
                }
                i++;
            }
            
            if(i == n) {
                return player;
            }
        }

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */