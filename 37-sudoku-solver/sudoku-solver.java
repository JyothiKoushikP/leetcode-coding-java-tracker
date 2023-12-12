class Solution {
    public void solveSudoku(char[][] board) {
        char[][] result = new char[9][9];
        solveSudoku(board,0,0,result);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = result[i][j];
            }
        }
    }

    public void solveSudoku(char[][] sudoku, int r, int c, char[][] result) {
        if(r == sudoku.length) {
            for(int i = 0; i < sudoku.length; i++) {
                for(int j = 0; j < sudoku.length; j++) {
                    result[i][j] = sudoku[i][j];
                }
            }
            return;
        }

        if(sudoku[r][c] == '.') {
            for(int i = 1; i <= 9; i++) {
                if(isSafe(sudoku,r,c,i)) {
                    sudoku[r][c] = (char) ('0' + i);
                    if(c == sudoku.length - 1) {
                        solveSudoku(sudoku,r+1,0,result);
                    } else {
                        solveSudoku(sudoku,r,c+1,result);
                    }
                    sudoku[r][c] = '.';
                }
            }
        } else {
            if(c == sudoku.length - 1) {
                solveSudoku(sudoku,r+1,0,result);
            } else {
                solveSudoku(sudoku,r,c+1,result);
            }
        }


    }

    public boolean isSafe(char[][] sudoku, int r, int c, int value) {
        char ch = (char) ('0' + value);
        for(int i = 0; i < 9; i++) {
            if(sudoku[r][i] == ch) {
                return false;
            }
        }

        //check column
        for(int i = 0; i < 9; i++) {
            if(sudoku[i][c] == ch) {
                return false;
            }
        }

        //check grid
        int lowerRowLimit = r / 3;
        int upperRowLimit = (lowerRowLimit * 3) + 2;
        int lowerColumnLimit = c / 3;
        int upperColumnLimit = (lowerColumnLimit * 3) + 2;

        for(int i = lowerRowLimit * 3; i <= upperRowLimit; i++) {
            for(int j = lowerColumnLimit * 3; j <= upperColumnLimit; j++) {
                if(sudoku[i][j] == ch){
                    return false;
                }
            }
        }

        return true;
    }
}