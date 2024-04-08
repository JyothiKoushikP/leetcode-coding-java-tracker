class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            List<Integer> prev = triangle.get(i-1);
            for(int j = 0; j < row.size(); j++) {
                int m1 = j - 1 >= 0 ? prev.get(j-1) : Integer.MAX_VALUE;
                int m2 = j < prev.size() ? prev.get(j) : Integer.MAX_VALUE;
                row.set(j,Math.min(m1,m2) + row.get(j));
            }
        }
        List<Integer> last = triangle.get(triangle.size() - 1);
        int minResult = Integer.MAX_VALUE;
        for(int i = 0; i < last.size(); i++) {
            minResult = Math.min(minResult,last.get(i));
        }
        return minResult;
    }
}