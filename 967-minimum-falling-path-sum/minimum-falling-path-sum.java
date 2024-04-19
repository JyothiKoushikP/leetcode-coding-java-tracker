/*
TC: O(n2)
SC: O(1)
Using the input array as the auxilary space
Dynamic programming similar to minimum path sum
*/


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        if(matrix.length == 1 && matrix[0].length == 1) {
            return matrix[0][0];
        }
        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix[r].length; c++) {
                int currSum = matrix[r][c];
                int minSum = Integer.MAX_VALUE;
                if(r - 1 >= 0) {
                    minSum = Math.min(minSum, currSum + matrix[r-1][c]);
                    if(c - 1 >= 0) {
                        minSum = Math.min(minSum, currSum + matrix[r-1][c-1]);
                    }
                    if(c + 1 < matrix[0].length) {
                        minSum = Math.min(minSum,currSum + matrix[r-1][c+1]);
                    }
                    if(r == matrix.length - 1) {
                        result = Math.min(result,minSum);
                    }
                    matrix[r][c] = minSum;
                }
            }
        }
            return result;
    }
}
