class Solution {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] result = new int[r+1][c+1];
        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                result[i][j] = ((matrix[i-1][j-1] - '0') + (result[i][j-1]));
            }
        }

        for(int i = 0; i <= c; i++) {
            for(int j = 1; j <= r; j++) {
                result[j][i] += result[j-1][i];
            }
        }
        int maxSum = 0;
        if(result[r][c] == 0) {
            return 0;
        } else {
            maxSum = 1;
        }
        int min = Math.min(r,c);
        for(int i = min; i > 1; i--) {
            if(generateCount(result, i, r, c)) {
                maxSum = Math.max(i * i,maxSum);
            }
        }

        return maxSum;
    }

    public boolean generateCount(int[][] result, int size, int r, int c) {
        boolean sum = false;
        int requiredSize = (int)(Math.pow(size,2));
        int rowLimit  = r - ((r - size) + 1);
        int colLimit = c - ((c - size) + 1);

        for(int i = r; i > rowLimit; i--) {
            for(int j = c; j > colLimit; j--) {
               int ones = result[i][j] - (result[i][j-size] + result[i-size][j] - result[i-size][j-size]);
               if(ones == requiredSize){
                   sum = true;
                   break;
               }
            }
        }

        return sum;
    }
}