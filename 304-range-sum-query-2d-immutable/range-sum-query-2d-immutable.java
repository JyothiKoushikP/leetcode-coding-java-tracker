class NumMatrix {
    int[][] inputMatrix;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        inputMatrix = new int[m][n];
        for(int i = 0; i < m; i++) {
            int rowSum = 0;
            for(int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
                inputMatrix[i][j] = rowSum;
            }
        }
        for(int i = 0; i < n; i++) {
            int colSum = 0;
            for(int j = 0; j < m; j++) {
                colSum += inputMatrix[j][i];
                inputMatrix[j][i] = colSum;
            }
        }
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n; j++) {
                System.out.println(inputMatrix[i][j]);
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0) {
            return inputMatrix[row2][col2];
        } else {
            int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
            sum1 = inputMatrix[row2][col2];
            sum2 = (row1 != 0 && col1 != 0) ? inputMatrix[row1-1][col1-1] : 0;
            sum3 = (row1 != 0) ? inputMatrix[row1-1][col2] : 0;
            sum4 = (col1 != 0) ? inputMatrix[row2][col1-1] : 0;
            return sum1 - sum3 -sum4 + sum2;
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */