class Solution {
    public void setZeroes(int[][] matrix) {
       boolean isFirstRow = false, isFirstColumn = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) {
                        isFirstRow = true;
                    }
                    if(j == 0){
                        isFirstColumn = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
               for(int j = 1; j < matrix[0].length; j++) {
                   matrix[i][j] = 0;
               }
            }
        }

        for(int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                for(int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if(isFirstRow) {
            for(int j = 1; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(isFirstColumn) {
            for(int j = 1; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }

    }

}