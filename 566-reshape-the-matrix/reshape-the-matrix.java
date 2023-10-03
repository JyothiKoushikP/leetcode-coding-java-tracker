class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        int[][] result = new int[r][c];
        if((r == m && c == n) || (r*c != m*n)){
            return mat;
        } 
        int rowPos = 0, colPos = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                result[rowPos][colPos] = mat[i][j];
                if(colPos + 1 >= c) {
                    colPos = 0;
                    if(rowPos + 1 < r) {
                        rowPos++;
                    }
                } else {
                    colPos++;
                }
            }
        }

        return result;
    }
}