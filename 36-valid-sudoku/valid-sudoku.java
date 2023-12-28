class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] != '.') {
                    if (!(checkRowColumn(board, i, j, board[i][j], true) && checkRowColumn(board, i, j, board[i][j], false) && checkGrid(board, i, j, board[i][j]))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkRowColumn(char[][] board, int row, int column, char target, boolean isRow) {
        if (isRow) {
            for (int i = 0; i < board[0].length; i++) {
                if (i == column) {
                    continue;
                }
                if (board[row][i] == target) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < board.length; i++) {
                if (i == row) {
                    continue;
                }
                if (board[i][column] == target) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkGrid(char[][] board, int row, int column, char target) {
        int lowerRow = (3 * (row/3));
        int upperRow = (3 * (row/3)) + 2;
        int lowerColumn = (3 * (column/3));
        int upperColumn = (3 * (column/3)) + 2;

        for(int i = lowerRow; i<= upperRow; i++) {
            for(int j = lowerColumn; j<= upperColumn; j++) {
                if(i == row && j == column) {
                    continue;
                }
                if(board[i][j] == target){
                    return false;
                }
            }
        }
        return true;
    }
}