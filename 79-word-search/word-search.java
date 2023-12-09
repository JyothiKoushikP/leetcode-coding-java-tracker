class Solution {
    public boolean exist(char[][] board, String word) {
        boolean result = false;
        char first = word.charAt(0);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == first) {
                    if(wordSearch(board,i,j,word,0)) {
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }
    
       public static boolean wordSearch(char[][] board, int r, int c, String word, int pointer) {
        boolean result = false;
        if(board[r][c] == '1') {
            return false;
        }
        if(board[r][c] != word.charAt(pointer)) {
            return false;
        }
        if(pointer == word.length() - 1) {
            return true;
        }
        char ch = board[r][c];
        board[r][c] = '1';
        if(r > 0) {
            result |= wordSearch(board,r-1,c,word,pointer + 1);
        }
        if(r < board.length - 1) {
            result |= wordSearch(board,r+1,c,word,pointer + 1);
        }
        if(c > 0) {
            result |= wordSearch(board,r,c-1,word,pointer + 1);
        }
        if(c < board[0].length - 1) {
            result |= wordSearch(board,r,c+1,word,pointer + 1);
        }

        board[r][c] = ch;
        return result;
    }

}