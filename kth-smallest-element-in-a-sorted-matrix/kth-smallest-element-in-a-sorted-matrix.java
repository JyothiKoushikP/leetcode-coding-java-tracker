class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int total = n * n;
        int minimum = Integer.MAX_VALUE;
        HashMap<Integer,Integer> res = new HashMap();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                res.put(matrix[i][j],res.getOrDefault(matrix[i][j],0) + 1);
                minimum = Math.min(minimum,matrix[i][j]);
            }
        }
        int count = 0;
        while(count <= total) {
            if(res.containsKey(minimum)) {
                count += res.get(minimum);
            }
            if(count >= k) {
                return minimum;
            }
            minimum++;
        }
        return 0;
    }
}