class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int rowPos = 0, colPos = n-1;
        while(colPos >= 0) {
            int r = 0, c = colPos;
            int ele = matrix[r][c];
            while(r < m && c < n) {
                if(matrix[r][c] != ele) {
                    return false;
                }
                r++;
                c++;
            }
            colPos--;
        }


        rowPos = m - 1;
        colPos = 0;
        while(rowPos >= 0) {
            int r = rowPos, c = 0;
            int ele = matrix[r][c];
            while(r < m && c < n) {
                if(matrix[r][c] != ele) {
                    return false;
                }
                r++;
                c++;
            }
            rowPos--;
        }

        return true;
    }
}