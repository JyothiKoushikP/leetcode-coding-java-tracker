class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        int sc = -1, ec = matrix[0].length - 1;
        int sr = -1, er = matrix.length - 1;
        int product = matrix.length * matrix[0].length;

        while (sr <= er && sc <= ec) {
            for(int i = sc + 1; i <= ec; i++) {
                result.add(matrix[sr + 1][i]);
            }
            if(result.size() == product){
                break;
            }
            sr++;
            for(int i = sr + 1; i <= er; i++) {
                result.add(matrix[i][ec]);
            }
            if(result.size() == product){
                break;
            }
            ec--;
            for(int i = ec; i > sc; i--){
                result.add(matrix[er][i]);
            }
            if(result.size() == product){
                break;
            }
            er--;
            for(int i = er; i > sr; i--){
                result.add(matrix[i][sc + 1]);
            }
            if(result.size() == product){
                break;
            }
            sc++;
        }

        return result;
    }
}