class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int sc = -1, ec = n-1;
        int sr = -1, er = n-1;
        int product = n * n;

        int num = 1;
        int count = 0;

        while (sr <= er && sc <= ec) {
            for(int i = sc + 1; i <= ec; i++) {
                matrix[sr + 1][i] = num++;
                count++;
            }
            if(count == product){
                break;
            }
            sr++;
            for(int i = sr + 1; i <= er; i++) {
                matrix[i][ec] = num++;
                count++;
            }
            if(count == product){
                break;
            }
            ec--;
            for(int i = ec; i > sc; i--){
                matrix[er][i] = num++;
                count++;
            }
            if(count == product){
                break;
            }
            er--;
            for(int i = er; i > sr; i--){
                matrix[i][sc + 1] = num++;
                count++;
            }
            if(count == product){
                break;
            }
            sc++;
        }

        return matrix;
    }
}