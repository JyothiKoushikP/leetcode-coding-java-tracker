class Solution {
    public String tictactoe(int[][] moves) {
        int currentMoves = 0;
        int[][] rows = new int[3][2];
        int[][] columns = new int[3][2];
        int[] diagonal = new int[2];
        int[] antiDiagonal = new int[2];
        int turn = 1;
        for(int[] move: moves) {
            int r = move[0], c = move[1];
            rows[r][turn == 1 ? 0 : 1]++;
            columns[c][turn == 1 ? 0 : 1]++;
            if(r == c) {
                diagonal[turn == 1 ? 0 : 1]++;
            } 
            if(r + c == 2) {
                antiDiagonal[turn == 1 ? 0 : 1]++;
            } 
            if(rows[r][turn == 1 ? 0 : 1] == 3 || columns[c][turn == 1 ? 0 : 1] == 3 || antiDiagonal[turn == 1 ? 0 : 1] == 3 || diagonal[turn == 1 ? 0 : 1] == 3) {
                return turn == 1 ? "A" : "B";
            }
            turn *= -1;
            currentMoves++;
        }
        return currentMoves == 9 ? "Draw" : "Pending";
    }
}