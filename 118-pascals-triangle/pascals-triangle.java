class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> row1 = new ArrayList();
        row1.add(1);
        result.add(row1);
        if(numRows == 1){
            return result;
        }
        List<Integer> row2 = new ArrayList();
        row2.add(1);
        row2.add(1);
        result.add(row2);
        if(numRows == 2){
            return result;
        }
        for(int i = 2; i < numRows;i++) {
            List<Integer> row = new ArrayList();
            row.add(1);
            List<Integer> prev = result.get(i-1);

            for(int j = 1;j < prev.size(); j++) {
                row.add(prev.get(j-1) + prev.get(j));
            }
            row.add(1);
            result.add(row);
        }

        return result;
    }
}