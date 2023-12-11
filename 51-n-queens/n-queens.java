class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<StringBuilder> board = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for(int j = 0; j < n; j++) {
                row.append('.');
            }
            board.add(row);
        }
        nQueens(result,n,board,0);
        return result;
    }

public void nQueens(List<List<String>> result, int n, List<StringBuilder> board, int r) {
        if(r == n) {
            List<String> b = new ArrayList<>();
            for(StringBuilder row : board) {
                b.add(row.toString());
            }
            result.add(b);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(isSafe(board,r,i)) {
                (board.get(r)).setCharAt(i, 'Q');
                nQueens(result,n,board,r+1);
                (board.get(r)).setCharAt(i, '.');
            }
        }

    }

    public boolean isSafe(List<StringBuilder> board, int r, int c) {
       int n = board.size() ;
       for(int i = r ; i >= 0; i--) {
           if(board.get(i).charAt(c) == 'Q') {
               return false;
           }
       }
       int row = r, column = c;
       while(row >= 0 && column < n) {
           if(board.get(row).charAt(column) == 'Q') {
               return false;
           }
           row--;
           column++;
       }
       row = r;
       column = c;

        while(row >= 0 && column >= 0) {
            if(board.get(row).charAt(column) == 'Q') {
                return false;
            }
            row--;
            column--;
        }

        return true;
    }

}